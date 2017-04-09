package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;

/**
 * Created by pedro on 8/04/17.
 */
public abstract class MongoDAO {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private Datastore datastore;


    public MongoDAO(MongoClient mongoClient, MongoDatabase mongoDatabase, Datastore datastore) {
        this.mongoClient = mongoClient;
        this.mongoDatabase = mongoDatabase;
        this.datastore = datastore;
    }
}
