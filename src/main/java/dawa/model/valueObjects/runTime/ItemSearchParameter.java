package dawa.model.valueObjects.runTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class ItemSearchParameter {

    private int             id          = -1;
    private String          name        = "";
    private float           precioMax   = Float.MAX_VALUE;
    private float           precioMin   = 0f;
    private List<String>    keywords    = new ArrayList<>();
    private boolean         dispnible   = true;
    private List<String>    searchWords = new ArrayList<>();
    private String          orderBy     = "name";
    private boolean         ascendent   = true;


    public ItemSearchParameter(){}

    public ItemSearchParameter(int id, String name, float precioMax, float precioMin, boolean dispnible, String orderBy, boolean ascendent) {
        this.id = id;
        this.name = name;
        this.precioMax = precioMax;
        this.precioMin = precioMin;
        this.dispnible = dispnible;
        this.orderBy = orderBy;
        this.ascendent = ascendent;
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

    public float getPrecioMax() {
        return precioMax;
    }

    public void setPrecioMax(float precioMax) {
        this.precioMax = precioMax;
    }

    public float getPrecioMin() {
        return precioMin;
    }

    public void setPrecioMin(float precioMin) {
        this.precioMin = precioMin;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public boolean getDispnible() {
        return dispnible;
    }

    public void setDispnible(boolean dispnible) {
        this.dispnible = dispnible;
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

    public boolean getAscendent() {
        return ascendent;
    }

    public void setAscendent(boolean ascendent) {
        this.ascendent = ascendent;
    }
}
