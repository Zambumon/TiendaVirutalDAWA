package dawa.model.dao.api;

import dawa.model.VOs.*;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOUsers {

    void insertUser(Registered user);

    Registered getUser(String email);

    UserList searchUsers(UserSearchParameter search);

    void removeUser(Registered user);

    void updateUser(Registered user);

    String getHashPass(String email);

    void InsertHash(String mail, String hash);

}
