package dawa.model.VOs;

import org.mongodb.morphia.annotations.*;

/**
 * Created by pedro on 9/04/17.
 */

@Indexes(
        @Index(value = "userEmail", fields = @Field("userEmail"))
)
public class CryptedPass {

    @Id
    String userEmail;
    String cryptedPass;


    public CryptedPass(){}

    public CryptedPass(String userEmail, String cryptedPass) {
        this.userEmail = userEmail;
        this.cryptedPass = cryptedPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCryptedPass() {
        return cryptedPass;
    }

    public void setCryptedPass(String cryptedPass) {
        this.cryptedPass = cryptedPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CryptedPass that = (CryptedPass) o;

        return userEmail != null ? userEmail.equals(that.userEmail) : that.userEmail == null;
    }

    @Override
    public int hashCode() {
        return userEmail != null ? userEmail.hashCode() : 0;
    }
}
