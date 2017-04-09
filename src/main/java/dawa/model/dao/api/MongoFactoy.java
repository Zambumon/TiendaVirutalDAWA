package dawa.model.dao.api;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import dawa.model.dao.mongo.*;

/**
 * Created by pedro on 8/04/17.
 */
public class MongoFactoy implements IDAOFactory{

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private Datastore datastore;

    public MongoFactoy(){
        // To connect to mongodb server
        mongoClient = new MongoClient( "localhost" , 27017 );

        // Nos bajamos una BD
        mongoDatabase = mongoClient.getDatabase("discosBD");


        //Creamos la instancia de morphia (es el parser que recomienda mongo). Le tenemos que pasar nuestro modelo
        //para que lo mapee y haga su magia
        Morphia morphia = new Morphia();
        morphia.mapPackage("dawa.model.VOs");
        datastore = morphia.createDatastore(mongoClient, "discosBD");
        datastore.ensureIndexes();
    }

    @Override
    public IDAOItems getDAOItems() {
        return new DAOItems(mongoClient, mongoDatabase,datastore);
    }

    @Override
    public IDAOOrders getDAOOrders() {
        return new DAOOrders(mongoClient,mongoDatabase, datastore);
    }

    @Override
    public IDAOUsers getDAOUsers() {
        return new DAOUsers(mongoClient, mongoDatabase, datastore);
    }
}
