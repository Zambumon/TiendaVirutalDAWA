package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Permission;
import dawa.model.VOs.Registered;
import dawa.model.VOs.UserList;
import dawa.model.VOs.UserSearchParameter;

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
        Registered user = (Registered) getUser(req);
        String email = req.getParameter("userId");

        if (user.getEmail().equals(email) || user.hasPermission(Permission.SEE_USER_ACCOUNTS)) {
            UserList list = controller.getDaoUsers().searchUsers(new UserSearchParameter(email));
            Registered registered = list.getUsers().get(0);

            req.setAttribute("address", registered.getCurrentAddress());
            req.setAttribute("account", registered);
            req.setAttribute("user", user);
            dispatcher.showView("account.jsp", req, res);
        } else {
            dispatcher.showCatalog(req, res);
        }
    }
}
