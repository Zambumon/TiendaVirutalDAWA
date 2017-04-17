package dawa.model.VOs;

import java.util.HashMap;
import java.util.Map;

public enum Permission {

    ADD_ITEM,
    EDIT_ITEM,
    SEE_USER_ACCOUNTS,
    EDIT_USER_ACCOUNTS,
    REMOVE_USERS_ACCOUNTS,
    SEE_VIP_DISCOUNT,
    ORDER_ITEMS,
    SEARCH_ORDERS;

    private static final Map<String, Permission> map;

    static {
        map = new HashMap<>();
        for (Permission permission : values()) {
            map.put(permission.name(), permission);
        }
    }

    public static Map<String, Permission> asMap() {
        return map;
    }
}
