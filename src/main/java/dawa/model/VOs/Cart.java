package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class Cart {

    private List<LineItem> lines = new ArrayList<>();
    private double price;

    public Cart() {}

    public Cart(List<LineItem> lines, double price) {
        this.lines = lines;
        this.price = price;
    }

    public List<LineItem> getLines() {
        return lines;
    }

    public void setLines(List<LineItem> lines) {
        this.lines = lines;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cart copy() {
        List<LineItem> newLines = new ArrayList<>(lines.size());
        for (LineItem lineItem : lines) {
            newLines.add(new LineItem(lineItem.getItem(), lineItem.getAmount(), lineItem.getPrice(), lineItem.getTaxes()));
        }
        return new Cart(newLines, price);
    }
}
