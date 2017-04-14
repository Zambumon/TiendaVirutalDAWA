package dawa.model.VOs;

/**
 * Created by pedro on 8/04/17.
 */
public class LoggedOut extends User {

    @Override
    public boolean hasPermission(Permission permission) {
        return false;
    }

    @Override
    public boolean isRegistered() {
        return false;
    }
}
