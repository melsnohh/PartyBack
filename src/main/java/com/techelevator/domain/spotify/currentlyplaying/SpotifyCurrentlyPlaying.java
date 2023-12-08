
package com.techelevator.domain.spotify.currentlyplaying;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SpotifyCurrentlyPlaying {

    private Long timestamp;
    private Context context;
    private Integer progressMs;
    private CurrentlyPlayingItem item;
    private String currentlyPlayingType;
    private Actions actions;
    @JsonProperty("is_playing")
    private Boolean isPlaying;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Integer getProgressMs() {
        return progressMs;
    }

    public void setProgressMs(Integer progressMs) {
        this.progressMs = progressMs;
    }

    public CurrentlyPlayingItem getItem() {
        return item;
    }

    public void setItem(CurrentlyPlayingItem item) {
        this.item = item;
    }

    public String getCurrentlyPlayingType() {
        return currentlyPlayingType;
    }

    public void setCurrentlyPlayingType(String currentlyPlayingType) {
        this.currentlyPlayingType = currentlyPlayingType;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean isPlaying) {
        this.isPlaying = isPlaying;
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
        result = ((result* 31)+((this.item == null)? 0 :this.item.hashCode()));
        result = ((result* 31)+((this.isPlaying == null)? 0 :this.isPlaying.hashCode()));
        result = ((result* 31)+((this.context == null)? 0 :this.context.hashCode()));
        result = ((result* 31)+((this.currentlyPlayingType == null)? 0 :this.currentlyPlayingType.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.actions == null)? 0 :this.actions.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        result = ((result* 31)+((this.progressMs == null)? 0 :this.progressMs.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpotifyCurrentlyPlaying) == false) {
            return false;
        }
        SpotifyCurrentlyPlaying rhs = ((SpotifyCurrentlyPlaying) other);
        return (((((((((this.item == rhs.item)||((this.item!= null)&&this.item.equals(rhs.item)))&&((this.isPlaying == rhs.isPlaying)||((this.isPlaying!= null)&&this.isPlaying.equals(rhs.isPlaying))))&&((this.context == rhs.context)||((this.context!= null)&&this.context.equals(rhs.context))))&&((this.currentlyPlayingType == rhs.currentlyPlayingType)||((this.currentlyPlayingType!= null)&&this.currentlyPlayingType.equals(rhs.currentlyPlayingType))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.actions == rhs.actions)||((this.actions!= null)&&this.actions.equals(rhs.actions))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))))&&((this.progressMs == rhs.progressMs)||((this.progressMs!= null)&&this.progressMs.equals(rhs.progressMs))));
    }

}
