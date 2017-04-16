package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Order;
import dawa.model.VOs.Registered;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class Confirm extends Action {

    public Confirm(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        Registered user = (Registered) getUser(req);
        Order order = new Order();

        req.setAttribute("user", user);
        dispatcher.showView("registered/confirmation.jsp", req, res);
    }
}
