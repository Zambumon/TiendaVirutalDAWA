package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Address;
import dawa.model.VOs.Registered;
import dawa.model.VOs.UserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by cout970 on 2017/04/12.
 */
public class SignUp extends Action {

    public SignUp(ShopController controller, Dispatcher dispatcher, String path) {
        super(controller, dispatcher, path);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        if (Objects.equals(req.getMethod(), "POST")) {
            // User
            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String pass = req.getParameter("pass");
            // Address
            String firstLine = req.getParameter("firstLine");
            String secondLine = req.getParameter("secondLine");
            String postCode = req.getParameter("postCode");
            String country = req.getParameter("country");

            Address addr = new Address(firstLine, secondLine, postCode, country);
            Registered user = new Registered(name, email, UserType.NORMAL, addr);

            user = controller.getAccountManager().trySignUp(user, pass);
            if (user == null) {
                dispatcher.showView("access/login.jsp", req, res);
                return;
            }
            req.setAttribute("user", user);
        }
        dispatcher.showView("/", req, res);
    }
}
