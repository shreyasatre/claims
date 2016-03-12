package org.troytemple.dao.model;

/**
 * Created by bt_te on 3/2/2016.
 */
public class GetSessionResponse {

    private String isLoggedIn;

    private String username;

    public GetSessionResponse(String isLoggedIn, String username) {
        this.isLoggedIn = isLoggedIn;
        this.username = username;
    }

    public GetSessionResponse() {
    }

    public String getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(String isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
