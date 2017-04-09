package dawa.model.VOs;


import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */

@Indexes(
        @Index(value = "buyer", fields = @Field("buyer"))
)
public class Order {

    @Id
    private int id;
    private Date date;
    private double totalPrice;
    private double discountPercent;
    @Embedded
    private List<LineItem> orderLines;
    @Reference
    private Registered buyer;
    private Address destination;



    public Order() {
        this.orderLines = new ArrayList<>();
    }

    public Order(int id, Date date, double totalPrice, double discountPercent, Registered buyer, Address destination) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.discountPercent = discountPercent;
        this.buyer = buyer;
        this.destination = destination;
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

    public Registered getBuyer() {
        return buyer;
    }

    public void setBuyer(Registered buyer) {
        this.buyer = buyer;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
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
