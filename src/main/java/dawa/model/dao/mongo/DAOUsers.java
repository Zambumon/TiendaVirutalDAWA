package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dawa.model.VOs.*;
import dawa.model.dao.api.*;
import org.mongodb.morphia.Datastore;

import java.util.List;

import static java.lang.Math.min;


/**
 * Created by pedro on 8/04/17.
 */
public class DAOUsers extends MongoDAO implements IDAOUsers {

    public DAOUsers(MongoClient mongoClient, MongoDatabase mongoDatabase, Datastore datastore) {
        super(mongoClient, mongoDatabase, datastore);
    }


    @Override
    public void insertUser(Registered user) {
        datastore.save(user);
    }

    @Override
    public Registered getUser(String email) {
        return datastore.get(Registered.class, email);
    }

    @Override
    public UserList searchUsers(UserSearchParameter search) {

        List<Registered> lista = datastore.createQuery(Registered.class)
                .field("name").contains(search.getName())
                .field("email").contains(search.getEmail())
                .asList();

        return new UserList(lista.subList(0, min(lista.size(), search.getMaxSize())));
    }

    @Override
    public void removeUser(Registered user) {
        datastore.delete(Registered.class,user.getEmail());
    }

    @Override
    public void updateUser(Registered user) {
        datastore.save(user);
    }

    @Override
    public String getHashPass(String email) {
        return datastore.get(CryptedPass.class,email).getCryptedPass();
    }

    @Override
    public void InsertHash(String mail, String hash) {
        datastore.save(new CryptedPass(mail,hash));
    }
}
