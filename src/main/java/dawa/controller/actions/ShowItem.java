package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.Item;
import dawa.model.VOs.ItemList;
import dawa.model.VOs.ItemSearchParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class ShowItem extends Action {

    public ShowItem(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        ItemList list = controller.getDaoItems().searchItems(new ItemSearchParameter(itemId));
        if(list.getItems().isEmpty()){
            dispatcher.showView("catalog.jsp", req, res);
            return;
        }
        Item item = list.getItems().get(0);

        req.setAttribute("item", item);
        dispatcher.showView("item.jsp", req, res);
    }
}
