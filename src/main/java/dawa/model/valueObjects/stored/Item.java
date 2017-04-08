package dawa.model.valueObjects.stored;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pedro on 8/04/17.
 */
public class Item {

    private int id;
    private String name;
    private double price;
    private double taxes;
    private String description;
    private int stock;
    private Review review;
    private boolean available;
    private List<String> keywords;
    private Map<String, Object> properties;

    public Item(int id, String name, double price, double taxes, String description, int stock, Review review, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.taxes = taxes;
        this.description = description;
        this.stock = stock;
        this.review = review;
        this.available = available;
        this.keywords = new ArrayList<>();
        this.properties = new LinkedHashMap<>();
    }

    public Item(){
        this.keywords = new ArrayList<>();
        this.properties = new LinkedHashMap<>();
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id == item.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}