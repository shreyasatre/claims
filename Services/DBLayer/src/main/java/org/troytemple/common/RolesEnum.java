package org.troytemple.common;

/**
 * Created by bt_te on 3/1/2016.
 */
public enum RolesEnum {

    SUBMITTER("SUBMITTER"),
    APPROVER("APPROVER"),
    FINANCE("FINANCE"),
    ADMIN("ADMIN"),
    SUPER("SUPER");

    private String role;

    private RolesEnum(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
