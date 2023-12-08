package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEventRequestBody {

 @JsonProperty("party")
    private CreateParty createParty;

 @JsonProperty("user_id")
    private int userId;

    public CreateParty getCreateParty() {
        return createParty;
    }

    public void setCreateParty(CreateParty createParty) {
        this.createParty = createParty;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
