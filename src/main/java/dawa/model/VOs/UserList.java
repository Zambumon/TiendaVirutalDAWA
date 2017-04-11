package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
@SuppressWarnings("unused")
public class UserList {

    private List<Registered> users = new ArrayList<>();

    public UserList(){}

    public UserList(List<Registered> userList) {
        this.users = userList;
    }

    public List<Registered> getUsers() {
        return users;
    }

    public void setUsers(List<Registered> users) {
        this.users = users;
    }
}
