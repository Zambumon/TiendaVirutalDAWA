package dawa.model.VOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 8/04/17.
 */
public class UserList {

    private List<Item> userList = new ArrayList<>();

    public UserList(){};

    public UserList(List<Item> userList) {
        this.userList = userList;
    }

    public List<Item> getUserList() {
        return userList;
    }

    public void setUserList(List<Item> userList) {
        this.userList = userList;
    }
}
