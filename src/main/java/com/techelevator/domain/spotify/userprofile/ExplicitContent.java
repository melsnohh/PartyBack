
package com.techelevator.domain.spotify.userprofile;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class ExplicitContent {

    private Boolean filterEnabled;
    private Boolean filterLocked;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getFilterEnabled() {
        return filterEnabled;
    }

    public void setFilterEnabled(Boolean filterEnabled) {
        this.filterEnabled = filterEnabled;
    }

    public Boolean getFilterLocked() {
        return filterLocked;
    }

    public void setFilterLocked(Boolean filterLocked) {
        this.filterLocked = filterLocked;
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
        result = ((result* 31)+((this.filterLocked == null)? 0 :this.filterLocked.hashCode()));
        result = ((result* 31)+((this.filterEnabled == null)? 0 :this.filterEnabled.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExplicitContent) == false) {
            return false;
        }
        ExplicitContent rhs = ((ExplicitContent) other);
        return ((((this.filterLocked == rhs.filterLocked)||((this.filterLocked!= null)&&this.filterLocked.equals(rhs.filterLocked)))&&((this.filterEnabled == rhs.filterEnabled)||((this.filterEnabled!= null)&&this.filterEnabled.equals(rhs.filterEnabled))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
