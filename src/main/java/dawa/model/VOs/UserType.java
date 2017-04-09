package dawa.model.VOs;

import dawa.model.VOs.Permission;

import java.util.Arrays;
import java.util.List;

public enum UserType {

    VIP(Permission.SEE_VIP_DISCOUNT, Permission.ORDER_ITEMS),

    NORMAL(Permission.ORDER_ITEMS),

    ADMIN(
            Permission.ADD_ITEM,            Permission.EDIT_ITEM,               Permission.EDIT_USER_ACCOUNTS,
            Permission.SEARCH_ORDERS,       Permission.SEE_USER_ACCOUNTS,       Permission.REMOVE_USERS_ACCOUNTS
    );

    private List<Permission> permissions;


    private UserType(Permission ...args){
        this.permissions = Arrays.asList(args);
    }

    public boolean hasPermission(Permission p){
        return permissions.contains(p);
    }



}
