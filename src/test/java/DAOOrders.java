import dawa.model.VOs.*;
import dawa.model.dao.api.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;

import static junit.framework.TestCase.fail;

/**
 * Created by pedro on 11/04/17.
 */
public class DAOOrders {

    @Test
    public void doTest(){

        IDAOFactory f = new MongoFactory();

        IDAOItems daoItems = f.getDAOItems();
        IDAOUsers daoUsers = f.getDAOUsers();
        IDAOOrders daoOrders = f.getDAOOrders();


        Registered user = new Registered("user", "user@gmail.com", UserType.NORMAL,
                new Address("1","2","","4"));

        Item item = new Item(0,"item0",1.1,1.1,"palabra_1", 2,true);

        Order order1 = new Order(1, Calendar.getInstance().getTime(), 0,20.0,user,new Address());
        order1.getOrderLines().add(new LineItem(1,2,1.1,item));

        Order order2 = new Order(2, Calendar.getInstance().getTime(), 0,20.0,user,new Address());
        order2.getOrderLines().add(new LineItem(1,2,1.1,item));

        Order order3 = new Order(3, Calendar.getInstance().getTime(), 0,20.0,user,new Address());
        order3.getOrderLines().add(new LineItem(1,2,1.1,item));


        daoItems.insertItem(item);
        daoUsers.insertUser(user);

        daoOrders.insertOrder(order1);

        daoOrders.insertOrder(order2);

        try {
            daoOrders.insertOrder(order3);
            fail("Debería haber dado una excepción");
        }catch (IllegalArgumentException e){/*Nothing to do here*/}


        Assert.assertEquals(Arrays.asList(order1,order2), daoOrders.getUserOrders(user));
    }
}
