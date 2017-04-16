package dawa.controller;

import dawa.model.VOs.ItemList;
import dawa.model.VOs.ItemSearchParameter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cout970 on 2017/04/11.
 */
public class Dispatcher {
    private ShopController controller;

    public Dispatcher(ShopController controller) {
        this.controller = controller;
    }

    public void showView(String name, HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher(name);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void showCatalog( HttpServletRequest req, HttpServletResponse res){
        ItemList result = controller.getDaoItems().searchItems(new ItemSearchParameter());
        req.setAttribute("searchResult", result.getItems());
        showView("catalog.jsp", req, res);
    }
}
