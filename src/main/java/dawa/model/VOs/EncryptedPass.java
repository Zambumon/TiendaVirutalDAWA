package dawa.model.VOs;

import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

/**
 * Created by pedro on 9/04/17.
 */
@SuppressWarnings("WeakerAccess")
@Indexes(
        @Index(value = "userEmail", fields = @Field("userEmail"))
)
public class EncryptedPass {

    @Id
    String userEmail;
    String encryptedPass;


    public EncryptedPass() {
    }

    public EncryptedPass(String userEmail, String cryptedPass) {
        this.userEmail = userEmail;
        this.encryptedPass = cryptedPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEncryptedPass() {
        return encryptedPass;
    }

    public void setEncryptedPass(String encryptedPass) {
        this.encryptedPass = encryptedPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EncryptedPass that = (EncryptedPass) o;
        return userEmail != null ? userEmail.equals(that.userEmail) : that.userEmail == null;
    }

    @Override
    public int hashCode() {
        return userEmail != null ? userEmail.hashCode() : 0;
    }
}
