package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Registered;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by cout970 on 2017/04/11.
 */
public class LogIn extends Action {

    public LogIn(ShopController controller, Dispatcher dispatcher, String path) {
        super(controller, dispatcher, path);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {

        if (Objects.equals(req.getMethod(), "POST")) {
            String email = req.getParameter("email");
            String pass = req.getParameter("pass");
            Registered user = controller.getAccountManager().tryLogin(email, pass);

            if (user == null) {
                dispatcher.showView("access/login.jsp", req, res);
                return;
            }
        }
        dispatcher.showView("/", req, res);
    }
}
