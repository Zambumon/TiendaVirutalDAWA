package dawa.model.bussinesLogic;

import dawa.model.VOs.Order;

/**
 * Created by pedro on 8/04/17.
 */
public final class Cashier {


    public static void updatePrice(Order order){

        double precioTotal = order.getOrderLines()
                                .stream()
                                .mapToDouble(i -> i.getPrice()*i.getTaxes())
                                .sum()*order.getDiscountPercent();

        order.setTotalPrice(precioTotal);

    }
}
