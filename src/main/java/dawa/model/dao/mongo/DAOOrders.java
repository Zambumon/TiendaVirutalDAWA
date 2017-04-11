package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dawa.model.VOs.Item;
import dawa.model.VOs.LineItem;
import dawa.model.VOs.Order;
import dawa.model.VOs.Registered;
import dawa.model.dao.api.IDAOOrders;
import org.mongodb.morphia.AdvancedDatastore;

import java.util.*;

/**
 * Created by pedro on 8/04/17.
 */
public class DAOOrders extends MongoDAO implements IDAOOrders {

    public DAOOrders(MongoClient mongoClient, MongoDatabase mongoDatabase, AdvancedDatastore datastore) {
        super(mongoClient, mongoDatabase, datastore);
    }

    @Override
    public List<Order> getUserOrders(Registered client) {
        return datastore.createQuery(Order.class).field("buyer").equal(client).asList();
    }

    @Override
    public void insertOrder(Order order) {

        int lineItemIndex;
        boolean succeedTransaction = true;
        int timeOut = 300;
        Random rand = new Random(Calendar.getInstance().getTimeInMillis());

        do {
            if (!checkStock(order)) {
                throw new IllegalArgumentException("not enoung stock to make this order");
            }

            for (lineItemIndex = 0; lineItemIndex < order.getOrderLines().size(); lineItemIndex++) {

                succeedTransaction = reserveLine(order.getOrderLines().get(lineItemIndex));
                if (!succeedTransaction) {
                    break;
                }
            }

            //This only happens when another thread left the object without stock between the check and the reserves (unlikely)
            if (!succeedTransaction) {

                for (int i = 0; i < lineItemIndex; i++) {
                    cancelLineReserve(order.getOrderLines().get(i));
                }

                try {
                    int tiempoAdormir = (int) ((rand.nextDouble() + 0.5) * 100);
                    timeOut -= tiempoAdormir;

                    if (timeOut < 0) {
                        throw new IllegalArgumentException("not enoung stock to make this order");
                    }

                    Thread.sleep(tiempoAdormir);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (!succeedTransaction); //It is almost impossible that this iterate more than to times (max 6)

        datastore.save(order);
    }

    /* decrement the stock of the line atomicaly */
    private boolean reserveLine(LineItem l) {

        Item modified = datastore.findAndModify(

                datastore.createQuery(Item.class)
                        .field("id").equal(l.getItem().getId())
                        .field("stock").greaterThanOrEq(l.getAmount()),

                datastore.createUpdateOperations(Item.class)
                        .dec("stock", l.getAmount())
        );

        return modified != null;
    }

    private void cancelLineReserve(LineItem l) {
        Item modified = datastore.findAndModify(

                datastore.createQuery(Item.class)
                        .field("id").equal(l.getItem().getId())
                        .field("stock").greaterThanOrEq(l.getAmount()),

                datastore.createUpdateOperations(Item.class)
                        .inc("stock", l.getAmount())
        );
    }


    //This is not Thread safe but checking this will let the concurrency system less saturated
    private boolean checkStock(Order order) {

        int[] itemIds = order.getOrderLines().stream().mapToInt(i -> i.getItem().getId()).toArray();

        Map<Integer, Integer> amountNeeded = new HashMap<>();
        for (LineItem l : order.getOrderLines()) {
            amountNeeded.put(l.getItem().getId(), l.getAmount());
        }


        List<Item> items = datastore.createQuery(Item.class).field("id").in(Arrays.asList(itemIds)).asList();

        for (Item item : items) {
            if (item.getStock() < amountNeeded.get(item.getId())) {
                return false;
            }
        }

        return true;
    }
}






























