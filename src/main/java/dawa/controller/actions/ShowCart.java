package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Cart;
import dawa.model.VOs.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class ShowCart extends Action {

    public ShowCart(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);
        Cart cart = user.getCart();

        req.setAttribute("cart", cart);
        dispatcher.showView("cart.jsp", req, res);
    }
}
