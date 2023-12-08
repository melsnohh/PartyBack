
package com.techelevator.domain.spotify.playlistsongs;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SpotifyPlaylistSongs {

    private List<PlaylistItem> playlistItems;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public List<PlaylistItem> getItems() {
        return playlistItems;
    }

    public void setItems(List<PlaylistItem> playlistItems) {
        this.playlistItems = playlistItems;
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
        result = ((result* 31)+((this.playlistItems == null)? 0 :this.playlistItems.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpotifyPlaylistSongs) == false) {
            return false;
        }
        SpotifyPlaylistSongs rhs = ((SpotifyPlaylistSongs) other);
        return (((this.playlistItems == rhs.playlistItems)||((this.playlistItems != null)&&this.playlistItems.equals(rhs.playlistItems)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
