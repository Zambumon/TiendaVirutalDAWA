package dawa.model.dao.api;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOFactory {

    public IDAOItems getDAOItems();

    public IDAOOrders getDAOOrders();

    public IDAOUsers getDAOUsers();
}
