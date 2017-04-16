package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.ItemList;
import dawa.model.VOs.ItemSearchParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * Created by cout970 on 2017/04/12.
 */
public class SearchItems extends Action {

    public SearchItems(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        getUser(req);
        ItemSearchParameter params = new ItemSearchParameter();
        String orderBy = req.getParameter("order");
        String[] checkbox = req.getParameterValues("searchParameter");
        String searchText = req.getParameter("search");

        if (Objects.equals(orderBy, "ascendant")) {
            params.setDescendant(true);
        }

        if(checkbox != null) {
            if (Arrays.binarySearch(checkbox, "name") != -1) {
                params.setName(searchText);
            }

            if (Arrays.binarySearch(checkbox, "keywords") != -1) {
                params.setKeywords(Collections.singletonList(searchText));
            }

            if (Arrays.binarySearch(checkbox, "description") != -1) {
                params.setSearchWords(Collections.singletonList(searchText));
            }
        }

        ItemList result = controller.getDaoItems().searchItems(params);
        req.setAttribute("searchResult", result.getItems());
        dispatcher.showView("catalog.jsp", req, res);
    }
}
