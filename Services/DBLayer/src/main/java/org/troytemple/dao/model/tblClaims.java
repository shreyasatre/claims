package org.troytemple.dao.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by bt_te on 2/17/2016.
 */
public class tblClaims {

    private int intClaimsIdx;

    private int intLnkUserIdx;

    private int intLnkExpenseTypeIdx;

    private String strImagePath;

    private int intLnkClaimsStatus;

    private Timestamp dtmUploadDate;

    private Timestamp dtmApprovalDate;

    private String strDenyReason;

    private int intLnkCommitteeIdx;

    private int intLnkRecipientIdx;

    private String strDescription;

    private Double decPrice;
    public tblClaims(int intClaimsIdx, int intLnkUserIdx, int intLnkExpenseTypeIdx, String strImagePath, int intLnkClaimsStatus, Timestamp dtmUploadDate, Timestamp dtmApprovalDate, String strDenyReason, double price, int intLnkCommitteeIdx, int intLnkRecipientIdx,String strDescription) {
        this.intClaimsIdx = intClaimsIdx;
        this.intLnkUserIdx = intLnkUserIdx;
        this.intLnkExpenseTypeIdx = intLnkExpenseTypeIdx;
        this.strImagePath = strImagePath;
        this.intLnkClaimsStatus = intLnkClaimsStatus;
        this.dtmUploadDate = dtmUploadDate;
        this.dtmApprovalDate = dtmApprovalDate;
        this.strDenyReason = strDenyReason;
        this.decPrice = price;
        this.intLnkCommitteeIdx = intLnkCommitteeIdx;
        this.intLnkRecipientIdx = intLnkRecipientIdx;
        this.strDescription = strDescription;
    }

    public tblClaims() {
    }

    public int getIntClaimsIdx() {
        return intClaimsIdx;
    }

    public void setIntClaimsIdx(int intClaimsIdx) {
        this.intClaimsIdx = intClaimsIdx;
    }

    public int getIntLnkUserIdx() {
        return intLnkUserIdx;
    }

    public void setIntLnkUserIdx(int intLnkUserIdx) {
        this.intLnkUserIdx = intLnkUserIdx;
    }

    public int getIntLnkExpenseTypeIdx() {
        return intLnkExpenseTypeIdx;
    }

    public void setIntLnkExpenseTypeIdx(int intLnkExpenseTypeIdx) {
        this.intLnkExpenseTypeIdx = intLnkExpenseTypeIdx;
    }

    public String getStrImagePath() {
        return strImagePath;
    }

    public void setStrImagePath(String strImagePath) {
        this.strImagePath = strImagePath;
    }

    public int getIntLnkClaimsStatus() {
        return intLnkClaimsStatus;
    }

    public void setIntLnkClaimsStatus(int intLnkClaimsStatus) {
        this.intLnkClaimsStatus = intLnkClaimsStatus;
    }

    public String getStrDenyReason() {
        return strDenyReason;
    }

    public void setStrDenyReason(String strDenyReason) {
        this.strDenyReason = strDenyReason;
    }

    public Timestamp getDtmUploadDate() {
        return dtmUploadDate;
    }

    public void setDtmUploadDate(Timestamp dtmUploadDate) {
        this.dtmUploadDate = dtmUploadDate;
    }

    public Timestamp getDtmApprovalDate() {
        return dtmApprovalDate;
    }

    public void setDtmApprovalDate(Timestamp dtmApprovalDate) {
        this.dtmApprovalDate = dtmApprovalDate;
    }

    public Double getDecPrice() {
        return decPrice;
    }

    public void setDecPrice(Double decPrice) {
        this.decPrice = decPrice;
    }

    public int getIntLnkCommitteeIdx() {
        return intLnkCommitteeIdx;
    }

    public void setIntLnkCommitteeIdx(int intLnkCommitteeIdx) {
        this.intLnkCommitteeIdx = intLnkCommitteeIdx;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public int getIntLnkRecipientIdx() {
        return intLnkRecipientIdx;
    }

    public void setIntLnkRecipientIdx(int intLnkRecipientIdx) {
        this.intLnkRecipientIdx = intLnkRecipientIdx;
    }
}
