package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class AdminAcount extends Action {

    public AdminAcount(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {

    }
}
