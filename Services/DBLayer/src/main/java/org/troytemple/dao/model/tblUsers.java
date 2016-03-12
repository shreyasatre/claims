package org.troytemple.dao.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bt_te on 1/30/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class tblUsers {

    private String intUserIdx;

    private String strMembershipID;

    private String strName;

    private String strUsername;

    private String strAddress;

    private int intLnkAccountStatus;

    @JsonIgnore
    private int intCommitteeId;

    private String strRole;

    @JsonIgnore
    private String salt;

    public tblUsers(String intUserIdx, String strMembershipID, String strName, String strUsername, String strAddress, int intLnkAccountStatus, String role, String salt, int intCommitteeId) {
        this.intUserIdx = intUserIdx;
        this.strMembershipID = strMembershipID;
        this.strName = strName;
        this.strUsername = strUsername;
        this.strAddress = strAddress;
        this.intLnkAccountStatus = intLnkAccountStatus;
        this.strRole = role;
        this.salt = salt;
        this.intCommitteeId = intCommitteeId;
    }

    public tblUsers() {
    }

    public String getIntUserIdx() {
        return intUserIdx;
    }

    public void setIntUserIdx(String intUserIdx) {
        this.intUserIdx = intUserIdx;
    }

    public String getStrMembershipID() {
        return strMembershipID;
    }

    public void setStrMembershipID(String strMembershipID) {
        this.strMembershipID = strMembershipID;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress;
    }

    public int getIntLnkAccountStatus() {
        return intLnkAccountStatus;
    }

    public void setIntLnkAccountStatus(int intLnkAccountStatus) {
        this.intLnkAccountStatus = intLnkAccountStatus;
    }

    public String getStrRole() {
        return strRole;
    }

    public void setStrRole(String role) {
        this.strRole = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getIntCommitteeId() {
        return intCommitteeId;
    }

    public void setIntCommitteeId(int intCommitteeId) {
        this.intCommitteeId = intCommitteeId;
    }
}
