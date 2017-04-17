package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Permission;
import dawa.model.VOs.User;
import dawa.model.VOs.UserList;
import dawa.model.VOs.UserSearchParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class SearchUsers extends Action {

    public SearchUsers(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);

        if (user.hasPermission(Permission.SEE_USER_ACCOUNTS)) {
            UserSearchParameter params = new UserSearchParameter();
            params.setMaxSize(50);

            UserList list = controller.getDaoUsers().searchUsers(params);

            req.setAttribute("listOfUsers", list.getUsers());
            dispatcher.showView("listusers.jsp", req, res);
        } else {
            dispatcher.showError(0, "Permisos insuficientes", req, res);
        }
    }
}
