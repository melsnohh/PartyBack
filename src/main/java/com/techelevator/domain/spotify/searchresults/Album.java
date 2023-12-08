
package com.techelevator.domain.spotify.searchresults;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Album {

    private String albumGroup;
    private String albumType;
    private List<Artist> artists;
    private ExternalUrls__1 externalUrls;
    private String href;
    private String id;
    private List<Image> images;
    private Boolean isPlayable;
    private String name;
    private String releaseDate;
    private String releaseDatePrecision;
    private Integer totalTracks;
    private String type;
    private String uri;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getAlbumGroup() {
        return albumGroup;
    }

    public void setAlbumGroup(String albumGroup) {
        this.albumGroup = albumGroup;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public ExternalUrls__1 getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls__1 externalUrls) {
        this.externalUrls = externalUrls;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getIsPlayable() {
        return isPlayable;
    }

    public void setIsPlayable(Boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    public void setReleaseDatePrecision(String releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
    }

    public Integer getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(Integer totalTracks) {
        this.totalTracks = totalTracks;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.isPlayable == null)? 0 :this.isPlayable.hashCode()));
        result = ((result* 31)+((this.images == null)? 0 :this.images.hashCode()));
        result = ((result* 31)+((this.releaseDate == null)? 0 :this.releaseDate.hashCode()));
        result = ((result* 31)+((this.externalUrls == null)? 0 :this.externalUrls.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.albumGroup == null)? 0 :this.albumGroup.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.artists == null)? 0 :this.artists.hashCode()));
        result = ((result* 31)+((this.totalTracks == null)? 0 :this.totalTracks.hashCode()));
        result = ((result* 31)+((this.albumType == null)? 0 :this.albumType.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.releaseDatePrecision == null)? 0 :this.releaseDatePrecision.hashCode()));
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
        if ((other instanceof Album) == false) {
            return false;
        }
        Album rhs = ((Album) other);
        return ((((((((((((((((this.isPlayable == rhs.isPlayable)||((this.isPlayable!= null)&&this.isPlayable.equals(rhs.isPlayable)))&&((this.images == rhs.images)||((this.images!= null)&&this.images.equals(rhs.images))))&&((this.releaseDate == rhs.releaseDate)||((this.releaseDate!= null)&&this.releaseDate.equals(rhs.releaseDate))))&&((this.externalUrls == rhs.externalUrls)||((this.externalUrls!= null)&&this.externalUrls.equals(rhs.externalUrls))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.albumGroup == rhs.albumGroup)||((this.albumGroup!= null)&&this.albumGroup.equals(rhs.albumGroup))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))))&&((this.artists == rhs.artists)||((this.artists!= null)&&this.artists.equals(rhs.artists))))&&((this.totalTracks == rhs.totalTracks)||((this.totalTracks!= null)&&this.totalTracks.equals(rhs.totalTracks))))&&((this.albumType == rhs.albumType)||((this.albumType!= null)&&this.albumType.equals(rhs.albumType))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.releaseDatePrecision == rhs.releaseDatePrecision)||((this.releaseDatePrecision!= null)&&this.releaseDatePrecision.equals(rhs.releaseDatePrecision))))&&((this.href == rhs.href)||((this.href!= null)&&this.href.equals(rhs.href))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
