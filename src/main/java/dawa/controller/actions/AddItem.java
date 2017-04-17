package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class AddItem extends Action {

    public AddItem(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String description = req.getParameter("description");
        String author = req.getParameter("cd-author");
        String country = req.getParameter("cd-country");
        String year = req.getParameter("cd-year");

        Item item = new Item();

        item.setName(name);
        item.setPrice(price);
        item.setStock(stock);
        item.getProperties().put("description", description);
        item.getProperties().put("author", author);
        item.getProperties().put("country", country);
        item.getProperties().put("year", year);

        controller.getDaoItems().insertItem(item);

        dispatcher.showView("addCD.jsp", req, res);
    }
}
