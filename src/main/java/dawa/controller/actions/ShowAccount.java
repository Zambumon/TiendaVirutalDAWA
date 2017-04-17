package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Registered;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/17.
 */
public class ShowAccount extends Action {

    public ShowAccount(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        Registered user = (Registered)getUser(req);

        req.setAttribute("address", user.getCurrentAddress());
        req.setAttribute("user", user);
        dispatcher.showView("account.jsp", req, res);
    }
}
