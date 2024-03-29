package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Item;
import dawa.model.VOs.Permission;
import dawa.model.VOs.User;

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

        User user = getUser(req);
        if(!user.hasPermission(Permission.ADD_ITEM)){
            dispatcher.showError(0, "Permisos insuficientes", req, res);
            return;
        }

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String author = req.getParameter("cd-author");
        String country = req.getParameter("cd-country");
        String year = req.getParameter("cd-year");

        double price;
        int stock;

        try {
            stock = Integer.parseInt(req.getParameter("stock"));
            price = Double.parseDouble(req.getParameter("price"));
        } catch (NumberFormatException e) {
            dispatcher.showError(0, "Formato de numero invalido: " + e.getMessage(), req, res);
            return;
        }

        Item item = new Item();

        item.setName(name);
        item.setPrice(price);
        item.setTaxes(1.21);
        item.setStock(stock);
        item.getProperties().put("description", description);
        item.getProperties().put("author", author);
        item.getProperties().put("country", country);
        item.getProperties().put("year", year);
        item.getKeywords().add(author);
        item.getKeywords().add(country);
        item.getKeywords().add(year);

        controller.getDaoItems().insertItem(item);

        dispatcher.showView("addCD.jsp", req, res);
    }
}
