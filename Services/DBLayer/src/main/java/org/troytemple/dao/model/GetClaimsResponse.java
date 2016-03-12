package org.troytemple.dao.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bt_te on 2/20/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetClaimsResponse implements Serializable{

    @JsonProperty
    private List<Claim> claims;

    public GetClaimsResponse(List<Claim> claims) {
        this.claims = claims;
    }


    public GetClaimsResponse() {
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }
}
