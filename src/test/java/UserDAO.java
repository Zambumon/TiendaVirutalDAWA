/**
 * Created by pedro on 9/04/17.
 */

import dawa.model.VOs.Adress;
import dawa.model.VOs.Registered;
import dawa.model.VOs.UserSearchParameter;
import dawa.model.VOs.UserType;
import dawa.model.dao.api.*;
import org.junit.Assert;
import org.junit.Test;

public class UserDAO {

    @Test
    public void insertUsers(){

        IDAOFactory factory = new MongoFactoy();

        IDAOUsers daoUsers = factory.getDAOUsers();

        for(int i = 0; i < 300; i++ ){

            Registered nuevo = new Registered("usuario"+i, "usuario"+i+"@gmail.com", UserType.NORMAL,
                                                new Adress("1","2",i+"","4"));
            daoUsers.insertUser(nuevo);
        }

        Assert.assertEquals(daoUsers.searchUsers(new UserSearchParameter()).getUserList().size(),300);
    }

}
