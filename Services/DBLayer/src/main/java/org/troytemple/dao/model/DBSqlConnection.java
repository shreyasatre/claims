package org.troytemple.dao.model;

/**
 * Created by bt_te on 2/2/2016.
 */
public class DBSqlConnection {

    private String forname;

    private String windowsAuthString;


    public DBSqlConnection(String forname, String windowsAuthString) {
        this.forname = forname;
        this.windowsAuthString = windowsAuthString;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getWindowsAuthString() {
        return windowsAuthString;
    }

    public void setWindowsAuthString(String windowsAuthString) {
        this.windowsAuthString = windowsAuthString;
    }
}
