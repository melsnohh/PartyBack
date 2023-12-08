package com.techelevator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackInfo {

    @JsonProperty("track_id")
    private String trackId;
    private String name;
    private String artist;
    @JsonProperty("image_url")
    private String imageUrl;

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

