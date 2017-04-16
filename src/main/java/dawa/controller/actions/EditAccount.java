package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Registered;
import dawa.model.VOs.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class EditAccount extends Action {

    public EditAccount(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User user = getUser(req);
        if(!(user instanceof Registered)){
            dispatcher.showView("access/login.jsp", req, res);
            return;
        }

        // TODO necesitamos una vista de perfil
        dispatcher.showView("/", req, res);
    }
}
