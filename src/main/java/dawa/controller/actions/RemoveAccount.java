package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
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

    public RemoveAccount(ShopController controller, Dispatcher dispatcher, String path) {
        super(controller, dispatcher, path);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);
        if (user.hasPermission(Permission.REMOVE_USERS_ACCOUNTS)) {

            String email = req.getParameter("userId");
            IDAOUsers dao = controller.getDaoUsers();
            Registered registered = dao.getUser(email);

            if(registered != null){
                dao.removeUser(registered);
                dao.deleteHash(email);
            }
            req.setAttribute("route", "searchusers");
            dispatcher.showView("shop", req, res);
        } else {
            controller.loadIndex(req, res);
        }
    }
}
