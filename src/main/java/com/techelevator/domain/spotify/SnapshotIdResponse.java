package com.techelevator.domain.spotify;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SnapshotIdResponse {

    private String snapshotId;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
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
        result = ((result* 31)+((this.snapshotId == null)? 0 :this.snapshotId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SnapshotIdResponse) == false) {
            return false;
        }
        SnapshotIdResponse rhs = ((SnapshotIdResponse) other);
        return (((this.snapshotId == rhs.snapshotId)||((this.snapshotId!= null)&&this.snapshotId.equals(rhs.snapshotId)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
