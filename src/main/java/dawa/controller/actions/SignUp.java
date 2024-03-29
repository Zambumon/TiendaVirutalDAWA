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

    public SignUp(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        if (Objects.equals(req.getMethod(), "POST")) {
            // User
            String email = req.getParameter("email");
            String name = req.getParameter("username");
            String pass = req.getParameter("pass");
            // Address
            String firstLine = req.getParameter("addressFirstLine");
            String secondLine = req.getParameter("addressSecondLine");
            String postCode = req.getParameter("addressPostcode");
            String country = req.getParameter("country");

            if (email == null || email.isEmpty() ||
                    name == null || name.isEmpty() ||
                    pass == null || pass.isEmpty() ||
                    firstLine == null || firstLine.isEmpty() ||
                    secondLine == null || secondLine.isEmpty() ||
                    postCode == null || postCode.isEmpty() ||
                    country == null || country.isEmpty()) {

                dispatcher.showError(0, "Datos de registro incompletos", req, res);
                return;
            }

            Address addr = new Address(firstLine, secondLine, postCode, country);
            Registered user = new Registered(name, email, UserType.NORMAL, addr);

            user = controller.getAccountManager().trySignUp(user, pass);
            if (user == null) {
                dispatcher.showError(0, "No se pudo registrar el usuario", req, res);
                return;
            }
            req.getSession().setAttribute("user", user);
            dispatcher.showCatalog(req, res);
        } else {
            dispatcher.showError(1, "Metodo GET no permitido", req, res);
        }
    }
}
