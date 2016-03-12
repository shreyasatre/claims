package org.troytemple.dao.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by bt_te on 2/20/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Claim implements Serializable {

    @JsonProperty
    public String expenseType;

    @JsonProperty
    public String submittedDate;

    @JsonProperty
    public String status;

    @JsonProperty
    public String description;

    @JsonProperty
    public String userName;

    @JsonProperty
    public String committee;

    @JsonProperty
    public Double price;

    public Claim() {
    }

    public Claim(String expenseType, String submittedDate, String status, String description, String userName, String committee, Double price) {
        this.expenseType = expenseType;
        this.submittedDate = submittedDate;
        this.status = status;
        this.description = description;
        this.userName = userName;
        this.committee = committee;
        this.price = price;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getSubmittedDate() {
        return this.submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
