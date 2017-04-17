package dawa.controller.actions;

import dawa.controller.Action;
import dawa.controller.Dispatcher;
import dawa.controller.ShopController;
import dawa.model.VOs.*;
import dawa.model.bussinesLogic.Cashier;
import dawa.model.bussinesLogic.MailSender;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by cout970 on 2017/04/12.
 */
public class Confirm extends Action {

    public Confirm(ShopController controller, Dispatcher dispatcher) {
        super(controller, dispatcher);
    }

    @Override
    public void doAction(HttpServletRequest req, HttpServletResponse res) {
        User auser = getUser(req);
        if(!(auser instanceof Registered)){
            dispatcher.showError(0, "Usuario no registrado", req, res);
            return;
        }
        Registered user = (Registered) auser;
        Cart cart = user.getCart().copy();
        Order order = new Order();

        //Date
        order.setDate(GregorianCalendar.getInstance().getTime());

        // Total price
        Cashier.updateCart(cart);
        order.setTotalPrice(cart.getPrice());

        // Discount
        order.setDiscountPercent(Cashier.getDiscount(user));

        //Order lines

        order.setOrderLines(cart.getLines());

        // Buyer
        order.setBuyer(user);

        // destination
        order.setDestination(user.getCurrentAddress());

        synchronized (this) {
            // Save in the DDBB
            controller.getDaoOrders().insertOrder(order);

            // Update stock
            for (LineItem line : cart.getLines()) {
                ItemList itemList = controller.getDaoItems().searchItems(new ItemSearchParameter(line.getItem().getId()));
                Item item = itemList.getItems().get(0);
                int newStock = Math.max(item.getStock() - line.getAmount(), 0);

                item.setStock(newStock);
                if (newStock == 0) {
                    item.setAvailable(false);
                }
                controller.getDaoItems().updateItem(item);
            }

            if(user.getType() == UserType.NORMAL) {
                List<Order> orders = controller.getDaoOrders().getUserOrders(user);
                double sum = 0;
                for (Order o : orders) {
                    sum += o.getTotalPrice();
                }
                if (sum > 100.0) {
                    user.setType(UserType.VIP);
                    controller.getDaoUsers().updateUser(user);
                }
            }
        }

        // Send Email
        try {
            MailSender
                    .getInstance()
                    .sendMail(
                            user.getEmail(),
                            "Compra realizada con exito",
                            "Se ha realizado tu compra en web.com con exito."
                    );
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // Clear Cart
        user.setCart(new Cart());

        req.setAttribute("user", user);
        dispatcher.showView("confirmation.jsp", req, res);
    }
}
