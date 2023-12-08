
package com.techelevator.domain.spotify.createdplaylist;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class SpotifyCreatedPlaylist {

    private Boolean collaborative;
    private String description;
    private ExternalUrls externalUrls;
    private Followers followers;
    private String href;
    private String id;
    private List<Object> images;
    private String name;
    private Owner owner;
    private Boolean _public;
    private String snapshotId;
    private Tracks tracks;
    private String type;
    private String uri;
    private Object primaryColor;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getCollaborative() {
        return collaborative;
    }

    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls externalUrls) {
        this.externalUrls = externalUrls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Object getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Object primaryColor) {
        this.primaryColor = primaryColor;
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
        result = ((result* 31)+((this.owner == null)? 0 :this.owner.hashCode()));
        result = ((result* 31)+((this.images == null)? 0 :this.images.hashCode()));
        result = ((result* 31)+((this.snapshotId == null)? 0 :this.snapshotId.hashCode()));
        result = ((result* 31)+((this._public == null)? 0 :this._public.hashCode()));
        result = ((result* 31)+((this.collaborative == null)? 0 :this.collaborative.hashCode()));
        result = ((result* 31)+((this.primaryColor == null)? 0 :this.primaryColor.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.externalUrls == null)? 0 :this.externalUrls.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.tracks == null)? 0 :this.tracks.hashCode()));
        result = ((result* 31)+((this.followers == null)? 0 :this.followers.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.href == null)? 0 :this.href.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpotifyCreatedPlaylist) == false) {
            return false;
        }
        SpotifyCreatedPlaylist rhs = ((SpotifyCreatedPlaylist) other);
        return (((((((((((((((((this.owner == rhs.owner)||((this.owner!= null)&&this.owner.equals(rhs.owner)))&&((this.images == rhs.images)||((this.images!= null)&&this.images.equals(rhs.images))))&&((this.snapshotId == rhs.snapshotId)||((this.snapshotId!= null)&&this.snapshotId.equals(rhs.snapshotId))))&&((this._public == rhs._public)||((this._public!= null)&&this._public.equals(rhs._public))))&&((this.collaborative == rhs.collaborative)||((this.collaborative!= null)&&this.collaborative.equals(rhs.collaborative))))&&((this.primaryColor == rhs.primaryColor)||((this.primaryColor!= null)&&this.primaryColor.equals(rhs.primaryColor))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.externalUrls == rhs.externalUrls)||((this.externalUrls!= null)&&this.externalUrls.equals(rhs.externalUrls))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))))&&((this.tracks == rhs.tracks)||((this.tracks!= null)&&this.tracks.equals(rhs.tracks))))&&((this.followers == rhs.followers)||((this.followers!= null)&&this.followers.equals(rhs.followers))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.href == rhs.href)||((this.href!= null)&&this.href.equals(rhs.href))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
