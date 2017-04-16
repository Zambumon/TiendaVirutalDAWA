package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.*;
import dawa.model.bussinesLogic.Cashier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cout970 on 2017/04/12.
 */
public class AddToCart extends Action {

    public AddToCart(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        int amount = Integer.parseInt(req.getParameter("amount"));

        User user = getUser(req);
        Cart cart = user.getCart();
        Item item = getItem(itemId);

        if(item == null){
            req.setAttribute("errorCode", 0);
            req.setAttribute("errorMsg", "ID del item invalida");
            dispatcher.showView("cart.jsp", req, res);
            return;
        }
        if(getItemCount(cart, item) + amount > item.getStock()){
            req.setAttribute("errorCode", 1);
            req.setAttribute("errorMsg", "Cantidad de items mayor que la del stock");
            dispatcher.showView("cart.jsp", req, res);
            return;
        }
        insert(cart, item, amount);
        Cashier.updateCart(cart);
        req.setAttribute("cart", cart);
        dispatcher.showView("cart.jsp", req, res);
    }

    private int getItemCount(Cart cart, Item item){
        for (LineItem line : cart.getLines()) {
            if(line.getItem().equals(item)){
                return line.getAmount();
            }
        }
        return 0;
    }

    private void insert(Cart cart, Item item, int amount){
        boolean found = false;
        for (LineItem line : cart.getLines()) {
            if(line.getItem().equals(item)){
                line.setAmount(line.getAmount() + amount);
                found = true;
                break;
            }
        }
        if(!found){
            LineItem newItem = new LineItem(item, amount);
            cart.getLines().add(newItem);
        }
    }

    private Item getItem(int itemId) {
        ItemSearchParameter params = new ItemSearchParameter();
        params.setId(itemId);
        ItemList list = controller.getDaoItems().searchItems(params);
        return list.getItems().size() > 0 ? list.getItems().get(0) : null;
    }
}
