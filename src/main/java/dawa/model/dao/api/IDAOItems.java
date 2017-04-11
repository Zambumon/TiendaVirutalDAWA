package dawa.model.dao.api;

import dawa.model.VOs.Item;
import dawa.model.VOs.ItemList;
import dawa.model.VOs.ItemSearchParameter;

/**
 * Created by pedro on 8/04/17.
 */
public interface IDAOItems {

    /**
     * @param param options of the search
     * @return Items that have the values described on param
     */
    ItemList searchItems(ItemSearchParameter param);

    /**
     * Insert an item, throw Illegal argument exception when it already exist
     *
     * @param item item to insert
     */
    void insertItem(Item item);

    /**
     * Save the values of the passed argument on the DB
     *
     * @param item item with updated values
     */
    void updateItem(Item item);

    /**
     * Delete the item witch item.id is equal to the item parameter
     *
     * @param item item to delete
     */
    void deleteItem(Item item);
}
