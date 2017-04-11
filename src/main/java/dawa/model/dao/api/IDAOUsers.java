package dawa.model.dao.api;

import dawa.model.VOs.Registered;
import dawa.model.VOs.UserList;
import dawa.model.VOs.UserSearchParameter;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOUsers {

    /**
     * Insert the user in the dataBase
     * If the user already exist throws an IllegalArgumentException
     *
     * @param user user we want to insert
     */
    void insertUser(Registered user);

    /**
     * Get the Registered associated to an Email, if it not exist return null
     *
     * @param email email of the user
     * @return return the user which has that email
     */
    Registered getUser(String email);

    /**
     * Return a list with the registered user corresponding with UserSearchParameter parameters
     *
     * @param search search parameters VO
     * @return return the list of users that correspond with search
     */
    UserList searchUsers(UserSearchParameter search);

    /**
     * Remove an user if exist, if not don't do anything
     *
     * @param user user we want to remove
     */
    void removeUser(Registered user);

    /**
     * Override the existing user data with the data of parameter user
     * If user do not exist it creates one with this parameter
     *
     * @param user user we want to update
     */
    void updateUser(Registered user);

    /**
     * Return the hashed password corresponding with the email
     * If the email do not exist return null
     */
    String getHashPass(String email);

    /**
     * Delete the password associated with the email
     * If there is no hashed password registered it does nothing
     */
    void deleteHash(String email);

    /**
     * Upset (set and create if not exist) the hash corresponding to the email
     */
    void insertHash(String mail, String hash);
}
