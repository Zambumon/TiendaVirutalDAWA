package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class ItemSearchParameter {

    private int             id          = -1;
    private String          name        = "";
    private float           maxPrice    = Float.MAX_VALUE;
    private float           minPrice    = 0f;
    private List<String>    keywords    = new ArrayList<>();
    private boolean         available   = true;
    private List<String>    searchWords = new ArrayList<>();
    private String          orderBy     = "name";
    private boolean         ascendant   = true;


    public ItemSearchParameter(){}

    public ItemSearchParameter(int id, String name, float maxPrice, float minPrice, boolean available, String orderBy,
                               boolean ascendant) {
        this.id = id;
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.available = available;
        this.orderBy = orderBy;
        this.ascendant = ascendant;
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

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
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

    public boolean getAscendant() {
        return ascendant;
    }

    public void setAscendant(boolean ascendant) {
        this.ascendant = ascendant;
    }
}
