package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {

    @JsonProperty("tag_id")
    private int tagId;
    @JsonProperty("tag_names")
    private String tagNames;

    public Tag(){}
    public Tag(int tagId, String tagNames) {
        this.tagId = tagId;
        this.tagNames = tagNames;
    }

    public Tag(String tagNames) {
        this.tagNames = tagNames;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagNames() {
        return tagNames;
    }

    public void setTagNames(String tagNames) {
        this.tagNames = tagNames;
    }
}
