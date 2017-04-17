package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.*;
import dawa.model.bussinesLogic.CryptUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by cout970 on 2017/04/12.
 */
public class EditAccount extends Action {

    public EditAccount(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        Registered user = (Registered) getUser(req);
        String email = req.getParameter("userId");

        if (user.getEmail().equals(email) || user.hasPermission(Permission.EDIT_USER_ACCOUNTS)) {
            Registered registered = controller.getDaoUsers().getUser(email);

            // Username
            registered.setName(req.getParameter("user-name"));

            // UserType
            String role = req.getParameter("role");
            if (role != null && user.hasPermission(Permission.EDIT_USER_ACCOUNTS)) {
                UserType type = UserType.valueOf(role);
                registered.setType(type);
            }

            // Password
            String pass = req.getParameter("pass");
            String passcheck = req.getParameter("passcheck");

            if (pass != null && !pass.isEmpty()) {
                if (Objects.equals(pass, passcheck)) {
                    String hash = CryptUtils.encrypt(pass);
                    controller.getDaoUsers().insertHash(registered.getEmail(), hash);
                }
            }

            controller.getDaoUsers().updateUser(registered);

            // Reload page
            req.setAttribute("address", registered.getCurrentAddress());
            req.setAttribute("user", user);
            req.setAttribute("account", registered);
            dispatcher.showView("account.jsp", req, res);
        } else {
            dispatcher.showCatalog(req, res);
        }
    }
}
