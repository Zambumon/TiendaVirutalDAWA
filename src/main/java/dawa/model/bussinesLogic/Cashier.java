package dawa.model.bussinesLogic;

import dawa.model.VOs.*;

/**
 * Created by pedro on 8/04/17.
 */
public final class Cashier {

    public static void updateCart(Cart cart) {

        double price = cart.getLines()
                .stream()
                .mapToDouble((l) -> l.getPrice() * l.getTaxes() * l.getAmount())
                .sum();

        cart.setPrice(price);
    }

    public static double getDiscount(Registered user){
        return user.getType() == UserType.VIP ? 0.2 : 0.0;
    }
}
