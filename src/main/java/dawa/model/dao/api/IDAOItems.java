package dawa.model.dao.api;

import dawa.model.VOs.*;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOItems {

    ItemList searchItems(ItemSearchParameter param);

    void insertItem(Item item);

    void updateItem(Item item);

    void deleteItem(Item item);
}
