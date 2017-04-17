package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.LoggedOut;
import dawa.model.VOs.Registered;
import dawa.model.VOs.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class LogOut extends Action {

    public LogOut(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);

        if (user instanceof Registered) {
            user = new LoggedOut();
            req.getSession().setAttribute("user", user);
            dispatcher.showCatalog(req, res);
        } else {
            dispatcher.showError(0, "El usuario no ha iniciado sesión", req, res);
        }
    }
}
