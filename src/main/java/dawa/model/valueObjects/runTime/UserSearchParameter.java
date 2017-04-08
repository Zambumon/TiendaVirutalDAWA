package dawa.model.valueObjects.runTime;

/**
 * Created by pedro on 8/04/17.
 */
public class UserSearchParameter {

    private String  name    = "";
    private String  email   = "";
    private int     maxSize = Integer.MAX_VALUE;


    public UserSearchParameter(String name, String email, int maxSize) {
        this.name       = name;
        this.email      = email;
        this.maxSize    = maxSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
