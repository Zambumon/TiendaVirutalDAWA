package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class ItemList {

    private List<Item> items = new ArrayList<>();

    public ItemList(){}

    public ItemList(List<Item> itemList) {
        this.items = itemList;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> itemList) {
        this.items = itemList;
    }
}
