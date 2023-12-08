
package com.techelevator.domain.spotify.currentlyplaying;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Disallows {

    private Boolean resuming;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getResuming() {
        return resuming;
    }

    public void setResuming(Boolean resuming) {
        this.resuming = resuming;
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
        result = ((result* 31)+((this.resuming == null)? 0 :this.resuming.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Disallows) == false) {
            return false;
        }
        Disallows rhs = ((Disallows) other);
        return (((this.resuming == rhs.resuming)||((this.resuming!= null)&&this.resuming.equals(rhs.resuming)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
