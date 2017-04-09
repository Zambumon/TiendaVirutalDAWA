package dawa.model.dao.api;

import dawa.model.VOs.*;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOOrders {

    void insertOrder(Order order);

    void getUserOrders(Registered client);

}
