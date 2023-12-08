
package com.techelevator.domain.spotify.searchresults;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SpotifySearchResults {

    private Tracks tracks;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.tracks == null)? 0 :this.tracks.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpotifySearchResults) == false) {
            return false;
        }
        SpotifySearchResults rhs = ((SpotifySearchResults) other);
        return (((this.tracks == rhs.tracks)||((this.tracks!= null)&&this.tracks.equals(rhs.tracks)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
