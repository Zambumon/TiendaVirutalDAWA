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

    public SearchItems(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        getUser(req);
        ItemSearchParameter params = new ItemSearchParameter();
        String title = req.getParameter("searchParameter-title");
        String author = req.getParameter("searchParameter-author");
        String country = req.getParameter("searchParameter-country");
        String year = req.getParameter("searchParameter-year");
        String maxPriceStr = req.getParameter("searchParameter-max-price");

        if (!title.isEmpty()) {
            params.setName(title);
        }
        if (!author.isEmpty()) {
            params.getKeywords().add(author);
        }
        if (!country.isEmpty()) {
            params.getKeywords().add(country);
        }
        if (!year.isEmpty()) {
            params.getKeywords().add(year);
        }
        if (!maxPriceStr.isEmpty()) {
            double maxPrice = Double.parseDouble(maxPriceStr);
            if(maxPrice > 1){
                params.setMaxPrice(maxPrice);
            }
        }

        ItemList result = controller.getDaoItems().searchItems(params);
        req.setAttribute("searchResult", result.getItems());
        dispatcher.showView("catalog.jsp", req, res);
    }
}
