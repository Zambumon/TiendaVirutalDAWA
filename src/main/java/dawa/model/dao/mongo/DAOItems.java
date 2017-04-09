package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dawa.model.VOs.Item;
import dawa.model.VOs.ItemList;
import dawa.model.VOs.ItemSearchParameter;
import dawa.model.dao.api.IDAOItems;
import org.mongodb.morphia.AdvancedDatastore;
import org.mongodb.morphia.query.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class DAOItems extends MongoDAO implements IDAOItems {

    public DAOItems(MongoClient mongoClient, MongoDatabase mongoDatabase, AdvancedDatastore datastore) {
        super(mongoClient, mongoDatabase, datastore);
    }


    @Override
    public ItemList searchItems(ItemSearchParameter param) {

        List<Item> result;

        Query query = datastore.createQuery(Item.class);
        List<Criteria> l = new ArrayList<Criteria>();



        if(param.getKeywords().size() != 0)
            l.add((Criteria)query.criteria("keywords").hasAllOf(param.getKeywords()));

        if(param.getId() != -1)
            l.add((Criteria)query.criteria("id").equal(param.getId()));

        if(param.getSearchWords().size() != 0)
            for(String word: param.getSearchWords())
                l.add((Criteria)query.criteria("description").contains(word));


        l.add((Criteria)query.criteria("price").greaterThan(param.getMinPrice()));
        l.add((Criteria)query.criteria("name").contains(param.getName()));
        l.add((Criteria)query.criteria("price").greaterThan(param.getMinPrice()));
        l.add((Criteria)query.criteria("price").lessThan(param.getMaxPrice()));
        l.add((Criteria)query.criteria("avaliable").equal(param.getAvailable()));

        Criteria[] criteriaArray = new Criteria[l.size()];
        criteriaArray = l.toArray(criteriaArray);
        query.and(criteriaArray);

        String orderParam = (param.getDescendent() ? "" : "-") + param.getOrderBy();
        result = query.order(orderParam).asList();

        return new ItemList(result);

    }

    @Override
    public void insertItem(Item item) {

        try {
            datastore.insert(item);
        } catch (com.mongodb.DuplicateKeyException e) {
            throw new IllegalArgumentException("The user already exists");
        }
    }

    @Override
    public void updateItem(Item item) {
        datastore.save(item);
    }

    @Override
    public void deleteItem(Item item) {
        datastore.delete(Item.class, item.getId());
    }
}
