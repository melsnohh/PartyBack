package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagParty {

    @JsonProperty("tag_id")
    private int tagId;

    @JsonProperty("party_id")
    private int partyId;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }
}
