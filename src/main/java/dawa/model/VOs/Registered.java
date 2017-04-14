package dawa.model.VOs;

import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@SuppressWarnings("unused")
@Indexes(
        @Index(value = "email", fields = @Field("email"))
)
public class Registered extends User {

    @Id
    private String email;
    private String name;
    private UserType type;
    private Address currentAddress;


    @Override
    public boolean hasPermission(Permission permission) {
        return type.hasPermission(permission);
    }

    public Registered(String name, String email, UserType type, Address currentAddress) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.currentAddress = currentAddress;
    }

    public Registered() {}

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

    @Override
    public boolean isRegistered() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Registered that = (Registered) o;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
