package org.troytemple.dao.model;

/**
 * Created by bt_te on 2/28/2016.
 */
public class tblPassword {

    private String password;

    private String status;

    private int invalidAttempts;

    public tblPassword(String password, String status, int invalidAttempts) {
        this.password = password;
        this.status = status;
        this.invalidAttempts = invalidAttempts;
    }

    public tblPassword() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getInvalidAttempts() {
        return invalidAttempts;
    }

    public void setInvalidAttempts(int invalidAttempts) {
        this.invalidAttempts = invalidAttempts;
    }
}
