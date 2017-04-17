package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cout970 on 2017/04/12.
 */
public class ShowItem extends Action {

    public ShowItem(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {

        Item item = getItem(req);
        if (item == null) {
            dispatcher.showError(0, "Id del item invalido", req, res);
            return;
        }

        req.setAttribute("item", item);
        req.setAttribute("canComment", canComment(req, item));
        dispatcher.showView("item.jsp", req, res);
    }

    private Item getItem(HttpServletRequest req) {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        ItemList list = controller.getDaoItems().searchItems(new ItemSearchParameter(itemId));

        return list.getItems().isEmpty() ? null : list.getItems().get(0);
    }

    private boolean canComment(HttpServletRequest req, Item item) {
        User user = getUser(req);
        if (user instanceof Registered) {
            Registered registered = (Registered) user;
            List<Order> orders = controller.getDaoOrders().getUserOrders(registered);

            for (Order order : orders) {
                for (LineItem lineItem : order.getOrderLines()) {
                    if (lineItem.getItem().getId() == item.getId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
