package com.techelevator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentlyPlaying {

    @JsonProperty("is_playing")
    private boolean isPlaying;
    private String name;
    private String artist;
    @JsonProperty("image_url")
    private String imageUrl;

    public CurrentlyPlaying() {
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
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
