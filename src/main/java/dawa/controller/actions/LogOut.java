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
public class LogOut extends Action {

    public LogOut(ShopController controller, Dispatcher dispatcher, String path) {
        super(controller, dispatcher, path);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);

        if(user instanceof Registered) {
            user = new LoggedOut();
            req.getSession().setAttribute("user", user);
        }
        controller.loadIndex(req, res);
    }
}
