/**
 * Created by pedro on 9/04/17.
 */

import dawa.model.VOs.Address;
import dawa.model.VOs.Registered;
import dawa.model.VOs.UserSearchParameter;
import dawa.model.VOs.UserType;
import dawa.model.dao.api.*;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class DAOUsers {

    @Test
    public void doTest(){

        IDAOFactory factory = new MongoFactory();

        IDAOUsers daoUsers = factory.getDAOUsers();

        //Insertions

        for(int i = 0; i < 300; i++ ){

            Registered nuevo = new Registered("user"+i, "user"+i+"@gmail.com", UserType.NORMAL,
                                                new Address("1","2",i+"","4"));
            daoUsers.insertUser(nuevo);
        }

        //Search

        UserSearchParameter busqueda1 = new UserSearchParameter("user","user",300);
        UserSearchParameter busqueda2 = new UserSearchParameter("user","user",10);
        UserSearchParameter busqueda3 = new UserSearchParameter("30","",300);

        Assert.assertEquals(300,daoUsers.searchUsers(busqueda1).getUsers().size());
        Assert.assertEquals(10,daoUsers.searchUsers(busqueda2).getUsers().size());
        Assert.assertEquals(3,daoUsers.searchUsers(busqueda3).getUsers().size());

        //search by key

        Registered r = daoUsers.getUser("user40@gmail.com");

        Assert.assertNotEquals(null,r);

        //remove

        daoUsers.removeUser(r);

        //Hashes

        daoUsers.insertHash("ej@ej","abcd");

        Assert.assertEquals("abcd",daoUsers.getHashPass("ej@ej"));

        daoUsers.deleteHash("ej@ej");

        Assert.assertEquals(null,daoUsers.getHashPass("ej@ej"));

        //non-valid arguments

        Assert.assertEquals(null,daoUsers.getUser("user40"));

        daoUsers.removeUser(r); //it simply not delete that


        //Insertion of an user with the same email

        daoUsers.insertUser(r);

        try {
            daoUsers.insertUser(r);
            fail("The user already exits and it hasn't had an error");
        }catch (IllegalArgumentException e){
            //ignore
        }

        //Delete all the users (if fails may still will remain users in the discosBD database)


        for(int i = 0; i < 300; i++ ){

            Registered borrar = new Registered("user"+i, "user"+i+"@gmail.com", UserType.NORMAL,
                    new Address("1","2",i+"","4"));
            daoUsers.removeUser(borrar);
        }

        Assert.assertEquals(0,daoUsers.searchUsers(busqueda1).getUsers().size());

    }

}
