package dawa.model.valueObjects.stored;

/**
 * Created by pedro on 8/04/17.
 */
public class Address {

    private String firstLine;
    private String secondLine;
    private String postCode;
    private String country;


    public Address(){};

    public Address(String firstLine, String secondLine, String postCode, String country) {
        this.firstLine  = firstLine;
        this.secondLine = secondLine;
        this.postCode   = postCode;
        this.country    = country;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address adress = (Address) o;

        if (firstLine != null ? !firstLine.equals(adress.firstLine) : adress.firstLine != null) return false;
        if (secondLine != null ? !secondLine.equals(adress.secondLine) : adress.secondLine != null) return false;
        if (postCode != null ? !postCode.equals(adress.postCode) : adress.postCode != null) return false;
        return country != null ? country.equals(adress.country) : adress.country == null;
    }

    @Override
    public int hashCode() {
        int result = firstLine != null ? firstLine.hashCode() : 0;
        result = 31 * result + (secondLine != null ? secondLine.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }


}
