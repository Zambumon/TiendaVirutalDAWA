package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dawa.model.VOs.Registered;
import dawa.model.VOs.User;
import dawa.model.VOs.UserList;
import dawa.model.VOs.UserSearchParameter;
import dawa.model.dao.api.IDAOUsers;
import org.mongodb.morphia.Datastore;

/**
 * Created by pedro on 8/04/17.
 */
public class DAOUsers extends MongoDAO implements IDAOUsers{

    public DAOUsers(MongoClient mongoClient, MongoDatabase mongoDatabase, Datastore datastore) {
        super(mongoClient, mongoDatabase, datastore);
    }


    @Override
    public void insertUser(Registered user) {

    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public UserList searchUsers(UserSearchParameter search) {
        return null;
    }

    @Override
    public void removeUser(Registered user) {

    }

    @Override
    public void updateUser(Registered user) {

    }

    @Override
    public String getHashPass(String email) {
        return null;
    }

    @Override
    public void InsertHash(String mail, String hash) {

    }
}
