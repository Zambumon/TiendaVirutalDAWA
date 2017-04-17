package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Permission;
import dawa.model.VOs.Registered;
import dawa.model.VOs.UserType;
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

        // Username
        user.setName(req.getParameter("user-name"));

        // UserType
        if (user.hasPermission(Permission.EDIT_USER_ACCOUNTS)) {
            UserType type = UserType.valueOf(req.getParameter("role"));
            user.setType(type);
        }

        // Password
        String pass = req.getParameter("pass");
        String passcheck = req.getParameter("passcheck");

        if (pass != null && !pass.isEmpty()) {
            if (Objects.equals(pass, passcheck)) {
                String hash = CryptUtils.encrypt(pass);
                controller.getDaoUsers().insertHash(user.getEmail(), hash);
            } else {
                req.setAttribute("address", user.getCurrentAddress());
                req.setAttribute("user", user);
                dispatcher.showView("account.jsp", req, res);
                return;
            }
        }

        // Reload page
        req.setAttribute("address", user.getCurrentAddress());
        req.setAttribute("user", user);
        dispatcher.showView("account.jsp", req, res);
    }
}
