
package com.techelevator.domain.spotify.currentlyplaying;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CurrentlyPlayingItem {

    private Album album;
    private List<Artist__1> artists;
    private Integer discNumber;
    private Integer durationMs;
    private Boolean explicit;
    private ExternalIds externalIds;
    private ExternalUrls__4 externalUrls;
    private String href;
    private String id;
    private Boolean isLocal;
    private Boolean isPlayable;
    private String name;
    private Integer popularity;
    private String previewUrl;
    private Integer trackNumber;
    private String type;
    private String uri;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Artist__1> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist__1> artists) {
        this.artists = artists;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public ExternalIds getExternalIds() {
        return externalIds;
    }

    public void setExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
    }

    public ExternalUrls__4 getExternalUrls() {
        return externalUrls;
    }

    public void setExternalUrls(ExternalUrls__4 externalUrls) {
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

    public Boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
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

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
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
        result = ((result* 31)+((this.previewUrl == null)? 0 :this.previewUrl.hashCode()));
        result = ((result* 31)+((this.trackNumber == null)? 0 :this.trackNumber.hashCode()));
        result = ((result* 31)+((this.album == null)? 0 :this.album.hashCode()));
        result = ((result* 31)+((this.externalIds == null)? 0 :this.externalIds.hashCode()));
        result = ((result* 31)+((this.externalUrls == null)? 0 :this.externalUrls.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.isLocal == null)? 0 :this.isLocal.hashCode()));
        result = ((result* 31)+((this.explicit == null)? 0 :this.explicit.hashCode()));
        result = ((result* 31)+((this.discNumber == null)? 0 :this.discNumber.hashCode()));
        result = ((result* 31)+((this.artists == null)? 0 :this.artists.hashCode()));
        result = ((result* 31)+((this.popularity == null)? 0 :this.popularity.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.href == null)? 0 :this.href.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.durationMs == null)? 0 :this.durationMs.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CurrentlyPlayingItem) == false) {
            return false;
        }
        CurrentlyPlayingItem rhs = ((CurrentlyPlayingItem) other);
        return (((((((((((((((((((this.isPlayable == rhs.isPlayable)||((this.isPlayable!= null)&&this.isPlayable.equals(rhs.isPlayable)))&&((this.previewUrl == rhs.previewUrl)||((this.previewUrl!= null)&&this.previewUrl.equals(rhs.previewUrl))))&&((this.trackNumber == rhs.trackNumber)||((this.trackNumber!= null)&&this.trackNumber.equals(rhs.trackNumber))))&&((this.album == rhs.album)||((this.album!= null)&&this.album.equals(rhs.album))))&&((this.externalIds == rhs.externalIds)||((this.externalIds!= null)&&this.externalIds.equals(rhs.externalIds))))&&((this.externalUrls == rhs.externalUrls)||((this.externalUrls!= null)&&this.externalUrls.equals(rhs.externalUrls))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))))&&((this.isLocal == rhs.isLocal)||((this.isLocal!= null)&&this.isLocal.equals(rhs.isLocal))))&&((this.explicit == rhs.explicit)||((this.explicit!= null)&&this.explicit.equals(rhs.explicit))))&&((this.discNumber == rhs.discNumber)||((this.discNumber!= null)&&this.discNumber.equals(rhs.discNumber))))&&((this.artists == rhs.artists)||((this.artists!= null)&&this.artists.equals(rhs.artists))))&&((this.popularity == rhs.popularity)||((this.popularity!= null)&&this.popularity.equals(rhs.popularity))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.href == rhs.href)||((this.href!= null)&&this.href.equals(rhs.href))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.durationMs == rhs.durationMs)||((this.durationMs!= null)&&this.durationMs.equals(rhs.durationMs))));
    }

}
