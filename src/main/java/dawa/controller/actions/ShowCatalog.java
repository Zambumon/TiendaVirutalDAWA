package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.ItemList;
import dawa.model.VOs.ItemSearchParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class ShowCatalog extends Action {

    public ShowCatalog(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        getUser(req);
        ItemList result = controller.getDaoItems().searchItems(new ItemSearchParameter());
        req.setAttribute("searchResult", result.getItems());
        dispatcher.showView("catalog.jsp", req, res);
    }
}
