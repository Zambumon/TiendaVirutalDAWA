package dawa.model.VOs;

/**
 * Created by pedro on 8/04/17.
 */
@SuppressWarnings("unused")
public class LineItem {

    private Item item;
    private int amount;
    private double price;
    private double taxes;


    public LineItem(){}

    public LineItem(Item item, int amount, double price, double taxes) {
        this.item = item;
        this.amount = amount;
        this.price = price;
        this.taxes = taxes;
    }

    public LineItem(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.price = item.getPrice();
        this.taxes = item.getTaxes();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
