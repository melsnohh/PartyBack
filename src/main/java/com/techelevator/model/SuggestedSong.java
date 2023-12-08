package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuggestedSong {


    @JsonProperty("song_id")
    private String songId;
    @JsonProperty("song_name")
    private String songName;
    private String artist;
    @JsonProperty("image_url")
    private String imageUrl;
    private int vote;

    public SuggestedSong() {
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
