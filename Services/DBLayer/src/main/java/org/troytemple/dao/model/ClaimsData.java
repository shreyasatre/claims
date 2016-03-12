package org.troytemple.dao.model;

import java.io.Serializable;

/**
 * Created by bt_te on 2/17/2016.
 */
public class ClaimsData implements Serializable {

    private String description;

    private String username;

    private String committee;

    private String price;

    private String imagePath;

    private String expenseType;

    public ClaimsData(String expenseType, String description, String username, String committee, String price, String imagePath1) {
        this.expenseType = expenseType;
        this.description = description;
        this.username = username;
        this.committee = committee;
        this.price = price;
        this.imagePath = imagePath;
    }

    public ClaimsData() {
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType.toUpperCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee.toUpperCase();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
