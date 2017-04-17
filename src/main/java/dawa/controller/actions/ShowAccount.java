package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Permission;
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
        Registered user = getRegistered(req);
        if(user == null){
            dispatcher.showError(0, "Usuario no registrado", req, res);
            return;
        }

        String email = req.getParameter("userId");

        if(email == null){
            dispatcher.showError(1, "email del usuario invalido", req, res);
            return;
        }

        if (user.getEmail().equals(email) || user.hasPermission(Permission.SEE_USER_ACCOUNTS)) {
            Registered registered = controller.getDaoUsers().getUser(email);

            req.setAttribute("address", registered.getCurrentAddress());
            req.setAttribute("account", registered);
            req.setAttribute("user", user);
            dispatcher.showView("account.jsp", req, res);
        } else {
            dispatcher.showError(2, "Permisos insuficientes", req, res);
        }
    }
}
