package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dawa.model.VOs.Order;
import dawa.model.VOs.Registered;
import dawa.model.dao.api.IDAOOrders;
import org.mongodb.morphia.Datastore;

/**
 * Created by pedro on 8/04/17.
 */
public class DAOOrders extends MongoDAO implements IDAOOrders{

    public DAOOrders(MongoClient mongoClient, MongoDatabase mongoDatabase, Datastore datastore) {
        super(mongoClient, mongoDatabase, datastore);
    }


    @Override
    public void insertOrder(Order order) {

    }

    @Override
    public void getUserOrders(Registered cliente) {

    }
}
