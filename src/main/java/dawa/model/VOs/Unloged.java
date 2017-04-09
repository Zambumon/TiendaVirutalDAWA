package dawa.model.VOs;

/**
 * Created by pedro on 8/04/17.
 */
public class Unloged extends User {
    @Override
    public boolean hasPermision(Permission permission) {
        return false;
    }

    @Override
    public boolean canComentItem(Item item) {
        return false;
    }
}
