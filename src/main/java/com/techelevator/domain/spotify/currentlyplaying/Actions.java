
package com.techelevator.domain.spotify.currentlyplaying;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Actions {

    private Disallows disallows;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Disallows getDisallows() {
        return disallows;
    }

    public void setDisallows(Disallows disallows) {
        this.disallows = disallows;
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
        result = ((result* 31)+((this.disallows == null)? 0 :this.disallows.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Actions) == false) {
            return false;
        }
        Actions rhs = ((Actions) other);
        return (((this.disallows == rhs.disallows)||((this.disallows!= null)&&this.disallows.equals(rhs.disallows)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
