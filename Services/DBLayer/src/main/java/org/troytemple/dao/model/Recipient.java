package org.troytemple.dao.model;

/**
 * Created by bt_te on 3/5/2016.
 */

public class Recipient {

    private int intRecipientId;
    private String firstName;

    private String lastName;

    private String nameOnCheck;

    private String address;

    private String city;

    private String state;

    private String zip;

    public Recipient(int intRecipientId, String firstName, String lastName, String nameOnCheck, String address, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameOnCheck = nameOnCheck;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.intRecipientId = intRecipientId;
    }

    public Recipient() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNameOnCheck() {
        return nameOnCheck;
    }

    public void setNameOnCheck(String nameOnCheck) {
        this.nameOnCheck = nameOnCheck;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getIntRecipientId() {
        return intRecipientId;
    }

    public void setIntRecipientId(int intRecipientId) {
        this.intRecipientId = intRecipientId;
    }
}
