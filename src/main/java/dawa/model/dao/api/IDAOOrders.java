package dawa.model.dao.api;

import dawa.model.VOs.*;

import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOOrders {

    void insertOrder(Order order);

    List<Order> getUserOrders(Registered client);

}
