package dawa.model.bussinesLogic;

import dawa.model.VOs.Cart;
import dawa.model.VOs.LineItem;
import dawa.model.VOs.Order;

/**
 * Created by pedro on 8/04/17.
 */
public final class Cashier {

    public static void updatePrice(Order order) {

        double totalPrice = order.getOrderLines()
                .stream()
                .mapToDouble(i -> i.getPrice() * i.getTaxes())
                .sum() * order.getDiscountPercent();

        order.setTotalPrice(totalPrice);
    }

    public static void updateCart(Cart cart) {

        double price = cart.getLines()
                .stream()
                .mapToDouble(LineItem::getPrice)
                .sum() * cart.getTaxes();

        cart.setPrice(price);
    }
}
