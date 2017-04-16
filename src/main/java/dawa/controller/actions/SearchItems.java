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
public class SearchItems extends Action {

    public SearchItems(ShopController controller, Dispatcher dispatcher, String path) {
        super(controller, dispatcher, path);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        getUser(req);
        ItemSearchParameter params = new ItemSearchParameter();
        //TODO que significa la interfaz, que hacen los checkbox? como buscas por id? etc...
//        System.out.println(Arrays.toString(req.getParameterValues("searchParameter")));

        ItemList result = controller.getDaoItems().searchItems(params);
        req.setAttribute("searchResult", result.getItems());
        dispatcher.showView("catalog.jsp", req, res);
    }
}
