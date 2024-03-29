package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.AdvancedDatastore;

/**
 * Created by pedro on 8/04/17.
 */
@SuppressWarnings("WeakerAccess")
public abstract class MongoDAO {

    protected MongoClient mongoClient;
    protected MongoDatabase mongoDatabase;
    protected AdvancedDatastore datastore;

    public MongoDAO(MongoClient mongoClient, MongoDatabase mongoDatabase, AdvancedDatastore datastore) {
        this.mongoClient = mongoClient;
        this.mongoDatabase = mongoDatabase;
        this.datastore = datastore;
    }
}
