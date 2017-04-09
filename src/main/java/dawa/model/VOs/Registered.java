package dawa.model.VOs;

import org.mongodb.morphia.annotations.*;

@Indexes(
        @Index(value = "email", fields = @Field("email"))
)
public class Registered extends User {


    @Id
    private String email;
    private String name;
    private UserType type;
    private Adress currentAdress;


    @Override
    public boolean hasPermision(Permission permission) {
        return type.hasPermission(permission);
    }

    @Override
    public boolean canComentItem(Item item) {
        /*TODO*/
        return false;
    }

    public Registered(String name, String email, UserType type, Adress currentAdress) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.currentAdress = currentAdress;
    }

    public Registered(){}


    public Adress getCurrentAdress() {
        return currentAdress;
    }

    public void setCurrentAdress(Adress currentAdress) {
        this.currentAdress = currentAdress;
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
