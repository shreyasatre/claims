package org.troytemple.common;

/**
 * Created by bt_te on 3/4/2016.
 */
public enum ClaimStatus {
    SUBMITTED(1),
    APPROVED(2),
    DENIED(3),
    DISPATCHED(4);

    private int status;
    private ClaimStatus(int status) {
     this.status = status;
    }

    public int getStatus(){
        return this.status;
    }

}
