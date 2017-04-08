package dawa.model.valueObjects.stored;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class Order {

    private int id;
    private Date date;
    private double totalPrice;
    private double discountPercent;
    private List<LineItem> orderLines;



    public Order() {
        this.orderLines = new ArrayList<>();
    }

    public Order(int id, Date date, double totalPrice, double discountPercent) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.discountPercent = discountPercent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public List<LineItem> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<LineItem> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
