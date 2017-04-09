package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dawa.model.VOs.Item;
import dawa.model.VOs.ItemList;
import dawa.model.VOs.ItemSearchParameter;
import dawa.model.dao.api.IDAOItems;
import org.mongodb.morphia.AdvancedDatastore;
import org.mongodb.morphia.Datastore;

/**
 * Created by pedro on 8/04/17.
 */
public class DAOItems extends MongoDAO implements IDAOItems{

    public DAOItems(MongoClient mongoClient, MongoDatabase mongoDatabase, AdvancedDatastore datastore) {
        super(mongoClient, mongoDatabase, datastore);
    }


    @Override
    public ItemList searchItems(ItemSearchParameter param) {
        return null;
    }

    @Override
    public void insertItem(Item item) {

    }

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public void deleteItem(Item item) {

    }
}
