package com.techelevator.services;

import com.techelevator.domain.CreatePlaylistRequestBody;
import com.techelevator.domain.DeleteSongFromPlaylistRequestBody;
import com.techelevator.domain.PlaySongFromSpotifyPlaylistRequestBody;
import com.techelevator.domain.TrackUri;
import com.techelevator.domain.spotify.SnapshotIdResponse;
import com.techelevator.domain.spotify.SpotifyTokenResponse;
import com.techelevator.domain.spotify.createdplaylist.SpotifyCreatedPlaylist;
import com.techelevator.domain.spotify.currentlyplaying.SpotifyCurrentlyPlaying;
import com.techelevator.domain.spotify.playlistsongs.SpotifyPlaylistSongs;
import com.techelevator.domain.spotify.searchresults.SpotifySearchResults;
import com.techelevator.domain.spotify.userprofile.SpotifyUserProfile;
import com.techelevator.exception.TokenMissingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@PropertySource("classpath:secrets.properties")
public class SpotifyApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    private SpotifyTokenResponse tokenInfo = null;

    // you must provide these in secrets.properties which is not saved in source control
    @Value("${CLIENT_ID}")
    private String clientId;

    @Value("${CLIENT_SECRET}")
    private String clientSecret;

    public SpotifyTokenResponse getToken(String code) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap();
        formData.add("code", code);
        formData.add("grant_type", "authorization_code");
//        formData.add("redirect_uri", "http://localhost:9000/receive-token");
        formData.add("redirect_uri", "http://52.205.180.163:9000/receive-token");

        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        headers.setBasicAuth(getAuthValue());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);

        try {
            ResponseEntity<SpotifyTokenResponse> response = restTemplate.exchange("https://accounts.spotify.com/api/token",
                    HttpMethod.POST, entity, SpotifyTokenResponse.class);
            tokenInfo = response.getBody();
            System.out.println(tokenInfo.getAccessToken());
            return tokenInfo;
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean refreshToken() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap();
        formData.add("grant_type", "refresh_token");
        formData.add("refresh_token", tokenInfo.getRefreshToken());

        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        headers.setBasicAuth(getAuthValue());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);

        try {
            ResponseEntity<SpotifyTokenResponse> response = restTemplate.exchange("https://accounts.spotify.com/api/token",
                    HttpMethod.POST, entity, SpotifyTokenResponse.class);
            SpotifyTokenResponse newTokenInfo = response.getBody();
            if (newTokenInfo.getAccessToken() != null) {
                tokenInfo.setAccessToken(newTokenInfo.getAccessToken());
                return true;
            }

        } catch (RestClientResponseException | ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    private String getAuthValue() {
        String authString = String.format("%s:%s", clientId, clientSecret);
        return Base64.getEncoder().encodeToString(authString.getBytes());
    }

    public SpotifyUserProfile getCurrentUserProfile() {
        try {
            ResponseEntity<SpotifyUserProfile> response = restTemplate.exchange("https://api.spotify.com/v1/me/",
                    HttpMethod.GET, makeGetEntity(tokenInfo.getAccessToken()), SpotifyUserProfile.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public SpotifyCreatedPlaylist createPlaylist(String currentSpotifyUserId, String partyName, String description) {
        try {
            ResponseEntity<SpotifyCreatedPlaylist> response = restTemplate.exchange("https://api.spotify.com/v1/users/" + currentSpotifyUserId + "/playlists\n",
                    HttpMethod.POST, makeCreatePlaylistEntity(tokenInfo.getAccessToken(), partyName, description), SpotifyCreatedPlaylist.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public SpotifySearchResults search(String term) {

        try {
            ResponseEntity<SpotifySearchResults> response = restTemplate.exchange("https://api.spotify.com/v1/search?q=" + term + "&type=track&limit=10",
                    HttpMethod.GET, makeGetEntity(tokenInfo.getAccessToken()), SpotifySearchResults.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public SnapshotIdResponse addTrackToSpotifyPlaylist(String playlistId, String trackUri) {

        try {
            ResponseEntity<SnapshotIdResponse> response = restTemplate.exchange("https://api.spotify.com/v1/playlists/" + playlistId + "/tracks?uris=" + trackUri,
                    HttpMethod.POST, makeGetEntity(tokenInfo.getAccessToken()), SnapshotIdResponse.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public SpotifyPlaylistSongs getSpotifyPlaylistSongs(String playlistId) {

        try {
            ResponseEntity<SpotifyPlaylistSongs> response = restTemplate.exchange("https://api.spotify.com/v1/playlists/" + playlistId + "/tracks" +
                            "?fields=items(track(name,href,album(name,href,images),artists(href,name),id))&limit=50",
                    HttpMethod.GET, makeGetEntity(tokenInfo.getAccessToken()), SpotifyPlaylistSongs.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public SnapshotIdResponse deleteSongFromSpotifyPlaylist(String playlistId, String songId) {
        try {
            ResponseEntity<SnapshotIdResponse> response = restTemplate.exchange("https://api.spotify.com/v1/playlists/" + playlistId + "/tracks",
                    HttpMethod.DELETE, makeDeleteSongFromPlaylistEntity(tokenInfo.getAccessToken(), songId), SnapshotIdResponse.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void playSpotifyPlaylist() {

        try {
            ResponseEntity<SnapshotIdResponse> response = restTemplate.exchange("https://api.spotify.com/v1/me/player/play",
                    HttpMethod.PUT, makeGetEntity(tokenInfo.getAccessToken()), SnapshotIdResponse.class);
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public SnapshotIdResponse playSongFromSpotifyPlaylist(String playlistId, String songId) {

        try {
            ResponseEntity<SnapshotIdResponse> response = restTemplate.exchange("https://api.spotify.com/v1/me/player/play",
                    HttpMethod.PUT, makePlaySongFromPlaylistEntity(tokenInfo.getAccessToken(), playlistId, songId), SnapshotIdResponse.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public void pauseSpotifyPlaylist() {

        try {
            ResponseEntity<SnapshotIdResponse> response = restTemplate.exchange("https://api.spotify.com/v1/me/player/pause",
                    HttpMethod.PUT, makeGetEntity(tokenInfo.getAccessToken()), SnapshotIdResponse.class);
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void nextSpotifyPlaylist() {

        try {
            ResponseEntity<SnapshotIdResponse> response = restTemplate.exchange("https://api.spotify.com/v1/me/player/next",
                    HttpMethod.POST, makeGetEntity(tokenInfo.getAccessToken()), SnapshotIdResponse.class);
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void previousSpotifyPlaylist() {

        try {
            ResponseEntity<SnapshotIdResponse> response = restTemplate.exchange("https://api.spotify.com/v1/me/player/previous",
                    HttpMethod.POST, makeGetEntity(tokenInfo.getAccessToken()), SnapshotIdResponse.class);
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public SpotifyCurrentlyPlaying getSpotifyCurrentlyPlaying() {
        try {
            ResponseEntity<SpotifyCurrentlyPlaying> response = restTemplate.exchange("https://api.spotify.com/v1/me/player/currently-playing?market=US",
                    HttpMethod.GET, makeGetEntity(tokenInfo.getAccessToken()), SpotifyCurrentlyPlaying.class);
            return response.getBody();
        } catch (RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getMessage().contains("access token expired")) {
                boolean refreshed = refreshToken();
                if (refreshed) {
                    System.out.println("refreshed");
                } else {
                    System.out.println("not refreshed");
                }
            }
        } catch (ResourceAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


    private HttpHeaders getHeaders(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(code);

        return headers;
    }

    public HttpEntity<Void> makeGetEntity(String code) {
        HttpHeaders headers = getHeaders(code);

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        return entity;
    }

    public HttpEntity<CreatePlaylistRequestBody> makeCreatePlaylistEntity(String code, String partyName, String description) {
        // Create request body
        CreatePlaylistRequestBody createPlaylistRequestBody = new CreatePlaylistRequestBody();
        createPlaylistRequestBody.setName(partyName);
        createPlaylistRequestBody.setDescription(description);

        // Create headers
        HttpHeaders headers = getHeaders(code);

        // Combine headers with request body
        HttpEntity<CreatePlaylistRequestBody> entity = new HttpEntity<>(createPlaylistRequestBody, headers);

        return entity;
    }

    public HttpEntity<DeleteSongFromPlaylistRequestBody> makeDeleteSongFromPlaylistEntity(String code, String songId) {

        // Create request body
        DeleteSongFromPlaylistRequestBody deleteSongFromPlaylistRequestBody = new DeleteSongFromPlaylistRequestBody();

        List<TrackUri> trackUris = new ArrayList<>();
        TrackUri trackUri = new TrackUri();
        trackUri.setUri("spotify:track:" + songId);
        trackUris.add(trackUri);

        deleteSongFromPlaylistRequestBody.setTrackUris(trackUris);

        // Create headers
        HttpHeaders headers = getHeaders(code);

        // Combine headers with request body
        HttpEntity<DeleteSongFromPlaylistRequestBody> entity = new HttpEntity<>(deleteSongFromPlaylistRequestBody, headers);

        return entity;
    }

    public HttpEntity<PlaySongFromSpotifyPlaylistRequestBody> makePlaySongFromPlaylistEntity(String code, String playlistId, String songId) {

        // Create request body
        PlaySongFromSpotifyPlaylistRequestBody playSongFromSpotifyPlaylistRequestBody = new PlaySongFromSpotifyPlaylistRequestBody();

        playSongFromSpotifyPlaylistRequestBody.setContextUri("spotify:playlist:" + playlistId);
        TrackUri trackUri = new TrackUri();
        trackUri.setUri("spotify:track:" + songId);

        playSongFromSpotifyPlaylistRequestBody.setOffset(trackUri);

        // Create headers
        HttpHeaders headers = getHeaders(code);

        // Combine headers with request body
        HttpEntity<PlaySongFromSpotifyPlaylistRequestBody> entity = new HttpEntity<>(playSongFromSpotifyPlaylistRequestBody, headers);

        return entity;

    }

    public void confirmTokenAvailable() {
        if (tokenInfo == null) {
            throw new TokenMissingException();
        }
    }

}
