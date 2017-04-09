package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class UserList {

    private List<Registered> userList = new ArrayList<>();

    public UserList(){};

    public UserList(List<Registered> userList) {
        this.userList = userList;
    }

    public List<Registered> getUserList() {
        return userList;
    }

    public void setUserList(List<Registered> userList) {
        this.userList = userList;
    }
}
