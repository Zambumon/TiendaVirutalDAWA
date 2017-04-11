package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Registered;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/11.
 */
public class LogIn extends Action {

    public LogIn(ShopController controller, Dispatcher dispatcher, String path) {
        super(controller, dispatcher, path);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        Registered user = controller.getAccountManager().tryLogin(email, pass);
        if (user == null) {
            dispatcher.showView("utils/error.jsp", req, res);
        } else {
            dispatcher.showView("search.jsp", req, res);
        }
    }
}
