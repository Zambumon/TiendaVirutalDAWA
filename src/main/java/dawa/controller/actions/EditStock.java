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
            String stcokStr = req.getParameter("stock");
            int stock = stcokStr == null ? 0 : Integer.parseInt(stcokStr);

            ItemList list = controller.getDaoItems().searchItems(new ItemSearchParameter(itemId));
            if (list.getItems().isEmpty()) {
                dispatcher.showError(1, "Id del item invalido", req, res);
                return;
            }
            Item item = list.getItems().get(0);
            item.setStock(stock);
            controller.getDaoItems().updateItem(item);

            req.setAttribute("route", "showitem");
            dispatcher.showView("shop", req, res);
        } else {
            dispatcher.showError(0, "Permisos insuficientes", req, res);
        }
    }
}
