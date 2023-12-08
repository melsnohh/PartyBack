package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class Party {

    @JsonProperty("party_id")
    private int partyId;
    @JsonProperty("party_name")
    private String partyName;
    private String description;
    private String passcode;
    @JsonProperty("playlist_id")
    private String playlistId;
    private String city;
    @JsonProperty("start_date")
    private LocalDate startDate;
    @JsonProperty("start_time")
    private LocalTime startTime;

    public Party(){};

    public Party(int partyId, String partyName, String description, String passcode, String playlistId, String city, LocalDate startDate, LocalTime startTime) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.description = description;
        this.passcode = passcode;
        this.playlistId = playlistId;
        this.city = city;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
