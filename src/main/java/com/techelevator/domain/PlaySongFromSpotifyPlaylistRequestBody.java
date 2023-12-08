package com.techelevator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaySongFromSpotifyPlaylistRequestBody {

    @JsonProperty("context_uri")
    private String contextUri;

    private TrackUri offset;

    public String getContextUri() {
        return contextUri;
    }

    public void setContextUri(String contextUri) {
        this.contextUri = contextUri;
    }

    public TrackUri getOffset() {
        return offset;
    }

    public void setOffset(TrackUri offset) {
        this.offset = offset;
    }
}
