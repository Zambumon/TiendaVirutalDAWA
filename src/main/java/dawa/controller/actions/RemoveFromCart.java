package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.*;
import dawa.model.bussinesLogic.Cashier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cout970 on 2017/04/12.
 */
public class RemoveFromCart extends Action {

    public RemoveFromCart(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        int itemId = Integer.parseInt(req.getParameter("itemId"));

        User user = getUser(req);
        Cart cart = user.getCart();
        Item item = getItem(itemId);

        if(item == null){
            dispatcher.showError(0, "Item Id invalido", req, res);
            return;
        }

        List<LineItem> lines = cart.getLines();
        int index = -1;
        for (int i = 0; i < lines.size(); i++) {
            LineItem line = lines.get(i);
            if (line.getItem().equals(item)) {
                index = i;
                break;
            }
        }
        if(index != -1){
            lines.remove(index);
        }

        Cashier.updateCart(cart);
        req.setAttribute("cart", cart);
        dispatcher.showView("cart.jsp", req, res);
    }

    private Item getItem(int itemId) {
        ItemSearchParameter params = new ItemSearchParameter();
        params.setId(itemId);
        ItemList list = controller.getDaoItems().searchItems(params);
        return list.getItems().size() > 0 ? list.getItems().get(0) : null;
    }
}
