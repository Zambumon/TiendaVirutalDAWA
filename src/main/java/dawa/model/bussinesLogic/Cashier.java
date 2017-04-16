package dawa.model.bussinesLogic;

import dawa.model.VOs.*;

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
                .mapToDouble((l) -> l.getPrice() * l.getTaxes())
                .sum();

        cart.setPrice(price);
    }

    public static double getDiscount(Registered user){
        return user.getType() == UserType.VIP ? 0.2 : 0.0;
    }
}
