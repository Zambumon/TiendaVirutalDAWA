package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class EditStock extends Action {

    public EditStock(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);
        if (user.hasPermission(Permission.EDIT_ITEM)) {

            int itemId = Integer.parseInt(req.getParameter("itemId"));
            int stock = Integer.parseInt(req.getParameter("stock"));

            ItemList list = controller.getDaoItems().searchItems(new ItemSearchParameter(itemId));
            if (list.getItems().isEmpty()) {
                dispatcher.showCatalog(req, res);
                return;
            }
            Item item = list.getItems().get(0);
            item.setStock(stock);
            controller.getDaoItems().updateItem(item);

            req.setAttribute("route", "showitem");
            dispatcher.showView("shop", req, res);
        } else {
            dispatcher.showCatalog(req, res);
        }
    }
}
