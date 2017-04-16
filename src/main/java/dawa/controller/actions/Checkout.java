package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Registered;
import dawa.model.VOs.User;
import dawa.model.bussinesLogic.Cashier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class Checkout extends Action {

    public Checkout(ShopController controller, Dispatcher dispatcher, String path) {
        super(controller, dispatcher, path);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);
        if (user instanceof Registered) {
            Cashier.updateCart(user.getCart());
            double discount = Cashier.getDiscount((Registered) user);
            double total = user.getCart().getPrice() * (1 - discount);

            req.setAttribute("discount", String.format("%.2f", discount));
            req.setAttribute("total", String.format("%.2f", total));
            req.setAttribute("cart", user.getCart());
            req.setAttribute("address", ((Registered) user).getCurrentAddress());

            dispatcher.showView("registered/checkout.jsp", req, res);
        } else {
            controller.loadIndex(req, res);
        }
    }
}
