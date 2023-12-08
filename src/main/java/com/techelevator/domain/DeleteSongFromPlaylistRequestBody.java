package com.techelevator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeleteSongFromPlaylistRequestBody {

    @JsonProperty("tracks")
    private List<TrackUri> trackUris;

    public List<TrackUri> getTrackUris() {
        return trackUris;
    }

    public void setTrackUris(List<TrackUri> trackUris) {
        this.trackUris = trackUris;
    }
}
