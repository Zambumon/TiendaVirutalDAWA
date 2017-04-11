package dawa.model.dao.api;

import dawa.model.VOs.*;

import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOOrders {


    /**
     * Try to insert an order, if there is not enough stock in the items of the order throws
     * an IllegalArgumentException
     * @param order Order to insert
     */
    void insertOrder(Order order);


    /**
     * Make a query of the orders of a determined client
     * @param client a Registered user
     * @return The orders made by de client
     */
    List<Order> getUserOrders(Registered client);

}
