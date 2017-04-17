package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class AddReview extends Action {

    public AddReview(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {

        Item item = getItem(req);
        if (item == null) {
            dispatcher.showError(0, "Id del item invalido", req, res);
            return;
        }

        Registered user = getRegistered(req);
        if (user == null) {
            dispatcher.showError(1, "Usuario no registrado", req, res);
            return;
        }



        String comment = req.getParameter("comment");
        String pointsStr = req.getParameter("points");
        int points;
        try {
            points = Integer.parseInt(pointsStr);
        } catch (Exception e){
            dispatcher.showError(2, "Puntos invalido", req, res);
            return;
        }

        Review review = new Review(user.getEmail(), user.getName(), points, comment);

        item.getReview().add(review);
        controller.getDaoItems().updateItem(item);

        req.setAttribute("item", item);
        req.setAttribute("canComment", true);
        dispatcher.showView("item.jsp", req, res);
    }

    private Item getItem(HttpServletRequest req) {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        ItemList list = controller.getDaoItems().searchItems(new ItemSearchParameter(itemId));

        return list.getItems().isEmpty() ? null : list.getItems().get(0);
    }

}
