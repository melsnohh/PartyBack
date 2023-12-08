package com.techelevator.domain;

import java.util.ArrayList;
import java.util.List;

public class Tracks {

    private List<TrackInfo> tracks = new ArrayList<>();

    public List<TrackInfo> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackInfo> tracks) {
        this.tracks = tracks;
    }

}
