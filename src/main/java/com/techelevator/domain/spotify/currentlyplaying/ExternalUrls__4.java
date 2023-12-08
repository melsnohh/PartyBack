
package com.techelevator.domain.spotify.currentlyplaying;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ExternalUrls__4 {

    private String spotify;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
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
        result = ((result* 31)+((this.spotify == null)? 0 :this.spotify.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExternalUrls__4) == false) {
            return false;
        }
        ExternalUrls__4 rhs = ((ExternalUrls__4) other);
        return (((this.spotify == rhs.spotify)||((this.spotify!= null)&&this.spotify.equals(rhs.spotify)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
