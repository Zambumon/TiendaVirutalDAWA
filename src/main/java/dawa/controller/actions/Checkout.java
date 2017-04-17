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

    public Checkout(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);
        if (user instanceof Registered) {
            Cashier.updateCart(user.getCart());
            double discount = Cashier.getDiscount((Registered) user);
            double total = user.getCart().getPrice() * (1 - discount);

            req.setAttribute("discount", discount);
            req.setAttribute("total", total);
            req.setAttribute("cart", user.getCart());
            req.setAttribute("address", ((Registered) user).getCurrentAddress());

            dispatcher.showView("checkout.jsp", req, res);
        } else {
            dispatcher.showError(0, "Usuario no registrado", req, res);
        }
    }
}
