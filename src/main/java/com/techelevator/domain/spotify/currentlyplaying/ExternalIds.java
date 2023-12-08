
package com.techelevator.domain.spotify.currentlyplaying;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ExternalIds {

    private String isrc;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
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
        result = ((result* 31)+((this.isrc == null)? 0 :this.isrc.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExternalIds) == false) {
            return false;
        }
        ExternalIds rhs = ((ExternalIds) other);
        return (((this.isrc == rhs.isrc)||((this.isrc!= null)&&this.isrc.equals(rhs.isrc)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
