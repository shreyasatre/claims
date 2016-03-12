package org.troytemple.dao.model;

/**
 * Created by bt_te on 3/5/2016.
 */
public class SubmitClaimRequest {

    private ClaimsData claimsData;

    private RecipientData recipientData;

    public SubmitClaimRequest(ClaimsData claimsData, RecipientData recipientData) {
        this.claimsData = claimsData;
        this.recipientData = recipientData;
    }

    public SubmitClaimRequest() {
    }

    public ClaimsData getClaimsData() {
        return claimsData;
    }

    public void setClaimsData(ClaimsData claimsData) {
        this.claimsData = claimsData;
    }

    public RecipientData getRecipientData() {
        return recipientData;
    }

    public void setRecipientData(RecipientData recipientData) {
        this.recipientData = recipientData;
    }
}
