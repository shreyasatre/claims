package org.troytemple.dao.model;

import java.io.Serializable;

/**
 * Created by bt_te on 2/14/2016.
 */
public class LoginRequest implements Serializable{
    private String username;

    private String password;

    public LoginRequest(){

    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }
}
