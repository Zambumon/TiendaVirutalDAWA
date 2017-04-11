package dawa.model.VOs;

/**
 * Created by pedro on 8/04/17.
 */
public class LineItem {

    private int amount;
    private double price;
    private double taxes;
    private Item item;


    public LineItem(){}

    public LineItem(int amount, double price, double taxes, Item item) {
        this.amount = amount;
        this.price = price;
        this.taxes = taxes;
        this.item = item;
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
