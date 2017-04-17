package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.LoggedOut;
import dawa.model.VOs.Permission;
import dawa.model.VOs.Registered;
import dawa.model.VOs.User;
import dawa.model.dao.api.IDAOUsers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class RemoveAccount extends Action {

    public RemoveAccount(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);
        String email = req.getParameter("userId");
        boolean ownAccount = user instanceof Registered && ((Registered) user).getEmail().equals(email);

        if (user.hasPermission(ownAccount ? Permission.REMOVE_OWN_ACCOUNT : Permission.REMOVE_USERS_ACCOUNTS)) {

            IDAOUsers dao = controller.getDaoUsers();
            Registered registered = dao.getUser(email);

            if(registered != null){
                dao.removeUser(registered);
                dao.deleteHash(email);
            }
            if(ownAccount){
                req.getSession().setAttribute("user", new LoggedOut());
            }
            req.setAttribute("route", "searchusers");
            dispatcher.showView("shop", req, res);
        } else {
            dispatcher.showCatalog(req, res);
        }
    }
}
