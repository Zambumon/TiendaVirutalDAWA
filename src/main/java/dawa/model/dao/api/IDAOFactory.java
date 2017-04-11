package dawa.model.dao.api;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOFactory {

    IDAOItems getDAOItems();

    IDAOOrders getDAOOrders();

    IDAOUsers getDAOUsers();
}
