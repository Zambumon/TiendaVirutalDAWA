package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class Cart {

    private List<LineItem> lines = new ArrayList<>();
    private double price;
    private double taxes; /*final price = price*taxes*/


    public Cart(double taxes){
        this.taxes = taxes;
    }

    public List<LineItem> getLines() {
        return lines;
    }

    public void setLines(List<LineItem> lines) {
        this.lines = lines;
    }

    public double getPrice() {
        return lines.stream().mapToDouble(LineItem::getPrice).sum()*taxes;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
}
