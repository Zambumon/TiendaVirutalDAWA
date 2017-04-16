package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public class ItemSearchParameter {

    //@formatter:off
    private int             id          = -1;
    private String          name        = "";
    private double          maxPrice    = Double.MAX_VALUE;
    private double          minPrice    = 0.0;
    private List<String>    keywords    = new ArrayList<>();
    private boolean         available   = true;
    private List<String>    searchWords = new ArrayList<>();
    private String          orderBy     = "name";
    private boolean         descendant  = true;
    //@formatter:om

    public ItemSearchParameter(){}

    public ItemSearchParameter(int id){
        this.id = id;
    }

    public ItemSearchParameter(int id, String name, double maxPrice, double minPrice, boolean available, String orderBy,
                               boolean descendant) {
        this.id = id;
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.available = available;
        this.orderBy = orderBy;
        this.descendant = descendant;
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

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<String> getSearchWords() {
        return searchWords;
    }

    public void setSearchWords(List<String> searchWords) {
        this.searchWords = searchWords;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean getDescendant() {
        return descendant;
    }

    public void setDescendant(boolean descendant) {
        this.descendant = descendant;
    }
}
