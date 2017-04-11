package dawa.model.dao.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import dawa.model.VOs.EncryptedPass;
import dawa.model.VOs.Registered;
import dawa.model.VOs.UserList;
import dawa.model.VOs.UserSearchParameter;
import dawa.model.dao.api.IDAOUsers;
import org.mongodb.morphia.AdvancedDatastore;

import java.util.List;

import static java.lang.Math.min;


/**
 * Created by pedro on 8/04/17.
 */
public class DAOUsers extends MongoDAO implements IDAOUsers {

    public DAOUsers(MongoClient mongoClient, MongoDatabase mongoDatabase, AdvancedDatastore datastore) {
        super(mongoClient, mongoDatabase, datastore);
    }

    @Override
    public void insertUser(Registered user) {
        try {
            datastore.insert(user);
        } catch (com.mongodb.DuplicateKeyException e) {
            throw new IllegalArgumentException("El usuario ya existe");
        }
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
        datastore.delete(Registered.class, user.getEmail());
    }

    @Override
    public void updateUser(Registered user) {
        datastore.save(user);
    }

    @Override
    public String getHashPass(String email) {

        EncryptedPass c = datastore.get(EncryptedPass.class, email);

        if (c == null) {
            return null;
        } else {
            return c.getEncryptedPass();
        }
    }

    @Override
    public void deleteHash(String email) {
        datastore.delete(EncryptedPass.class, email);
    }

    @Override
    public void insertHash(String mail, String hash) {
        datastore.save(new EncryptedPass(mail, hash));
    }
}
