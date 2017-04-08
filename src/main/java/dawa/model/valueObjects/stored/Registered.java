package dawa.model.valueObjects.stored;

import dawa.model.valueObjects.runTime.Permission;
import dawa.model.valueObjects.runTime.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class Registered extends User {

    private String name;
    private String email;
    private UserType type;
    private List<Order> ordersMade;
    private Address currentAddress;


    @Override
    public boolean hasPermision(Permission permission) {
        return type.hasPermission(permission);
    }

    @Override
    public boolean canCommentItem(Item item) {
        /*TODO*/
        return false;
    }

    public Registered(int id, String name, String email, UserType type, Address currentAddress) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.currentAddress = currentAddress;
        this.ordersMade = new ArrayList<>();
    }

    public Registered(){
        this.ordersMade = new ArrayList<>();
    }




    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Order> getOrdersMade() {
        return ordersMade;
    }

    public void setOrdersMade(List<Order> ordersMade) {
        this.ordersMade = ordersMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registered that = (Registered) o;

        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }


}
