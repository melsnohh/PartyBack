package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartySong {

    @JsonProperty("song_id")
    private String songId;
    @JsonProperty("party_id")
    private int partyId;
    private int vote;

    public PartySong(){}

    public PartySong(String songId, int partyId, int vote) {
        this.songId = songId;
        this.partyId = partyId;
        this.vote = vote;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}