import dawa.model.VOs.Item;
import dawa.model.VOs.ItemSearchParameter;
import dawa.model.dao.api.IDAOFactory;
import dawa.model.dao.api.IDAOItems;
import dawa.model.dao.api.MongoFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by pedro on 9/04/17.
 */
public class DAOItems {

    @Test
    public void doTest(){

        List<Item> listaItems = new ArrayList<>();

        listaItems.add(new Item(0,"item0",1.1,1.1,"palabra_1", 4,true));
        listaItems.add(new Item(1,"item1",2.0,1.1,"palabra_1 palabra_2", 4,true));
        listaItems.add(new Item(2,"item2",3.0,1.1,"descripción del item", 4,true));
        listaItems.add(new Item(3,"item3",0.5,1.1,"descripción del item", 4,true));
        listaItems.add(new Item(4,"item4",5.0,1.1,"descripción del item", 4,true));
        listaItems.add(new Item(5,"item5",6.0,1.1,"descripción del item", 4,false));
        listaItems.add(new Item(6,"item6",6.0,1.1,"descripción del item", 4,false));



        listaItems.get(0).getKeywords().add("key1");
        listaItems.get(0).getKeywords().add("key2");
        listaItems.get(1).getKeywords().add("key1");

        IDAOFactory factory = new MongoFactory();

        IDAOItems dao = factory.getDAOItems();

        //Insertions and updates

        for(Item item: listaItems)
            dao.insertItem(item);

        try{
            dao.insertItem(listaItems.get(0));
            fail("It shoud had fail on insert an existing item");
        }catch (IllegalArgumentException e){/*Everything is right*/}

        listaItems.get(1).getKeywords().add("key3");

        //deletes

        dao.deleteItem(listaItems.get(6));
        dao.deleteItem(listaItems.get(6)); //It should ignore it

        //searches


        ItemSearchParameter search = new ItemSearchParameter();
        search.setId(2);
        Assert.assertEquals(listaItems.get(2), dao.searchItems(search).getItems().get(0));




        search = new ItemSearchParameter();

        search.setAvailable(true);
        Assert.assertEquals(listaItems.subList(0,5), dao.searchItems(search).getItems());

        search.setMaxPrice(4.5f);
        Assert.assertEquals(listaItems.subList(0,4), dao.searchItems(search).getItems());

        search.setMinPrice(1f);
        Assert.assertEquals(listaItems.subList(0,3), dao.searchItems(search).getItems());

        search.getSearchWords().add("palabra");
        Assert.assertEquals(listaItems.subList(0,2), dao.searchItems(search).getItems());

        search.getKeywords().add("key1");
        search.getKeywords().add("key2");
        Assert.assertEquals(listaItems.subList(0,1), dao.searchItems(search).getItems());

        search.setName("item");
        Assert.assertEquals(listaItems.subList(0,1), dao.searchItems(search).getItems());

        search.setName("itemNo");
        Assert.assertEquals(new ArrayList<>(), dao.searchItems(search).getItems());



        search = new ItemSearchParameter();
        search.setOrderBy("price");
        search.setDescendant(true);

        Assert.assertEquals(listaItems.get(3), dao.searchItems(search).getItems().get(0));


        //Restore DB state

        for (Item a: listaItems)
            dao.deleteItem(a);


    }
}
