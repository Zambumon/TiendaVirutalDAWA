package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Registered;
import dawa.model.VOs.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by cout970 on 2017/04/11.
 */
public class LogIn extends Action {

    public LogIn(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        getUser(req);

        if (Objects.equals(req.getMethod(), "POST")) {
            String email = req.getParameter("email");
            String pass = req.getParameter("pass");
            User oldUser = getUser(req);
            Registered user = controller.getAccountManager().tryLogin(email, pass);

            if (user == null) {
                dispatcher.showError(0, "Par usuario-contraseña incorrecto", req, res);
                return;
            }
            user.setCart(oldUser.getCart());
            req.getSession().setAttribute("user", user);

            dispatcher.showCatalog(req, res);
        } else {
            dispatcher.showError(1, "Metodo Get no permitido", req, res);
        }
    }
}
