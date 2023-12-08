package com.techelevator.services;

import com.techelevator.domain.CurrentlyPlaying;
import com.techelevator.domain.Tracks;
import com.techelevator.domain.TrackInfo;
import com.techelevator.domain.spotify.SnapshotIdResponse;
import com.techelevator.domain.spotify.createdplaylist.SpotifyCreatedPlaylist;
import com.techelevator.domain.spotify.currentlyplaying.CurrentlyPlayingItem;
import com.techelevator.domain.spotify.currentlyplaying.SpotifyCurrentlyPlaying;
import com.techelevator.domain.spotify.playlistsongs.SpotifyPlaylistSongs;
import com.techelevator.domain.spotify.searchresults.Item;
import com.techelevator.domain.spotify.playlistsongs.PlaylistItem;
import com.techelevator.domain.spotify.searchresults.SpotifySearchResults;
import com.techelevator.domain.spotify.userprofile.SpotifyUserProfile;
import com.techelevator.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuxBoxService {

    private final static int RETRY_COUNT = 2;

    private final PartyService partyService;
    private final SongService songService;
    private final TagService tagService;
    private final SpotifyApiService spotifyApiService;
    private final PartySongService partySongService;

    public AuxBoxService(PartyService partyService, SongService songService, TagService tagService, SpotifyApiService spotifyApiService, PartySongService partySongService) {
        this.partyService = partyService;
        this.songService = songService;
        this.tagService = tagService;
        this.spotifyApiService = spotifyApiService;
        this.partySongService = partySongService;
    }

    public List<Party> getPartiesByUserId(int userId) {
        List<Party> partyList = new ArrayList<>();

        List<Integer> partyIdList = partyService.getPartyIdsByUser(userId);

        for (Integer curPartyId : partyIdList) {
            partyList.add(partyService.getPartyById(curPartyId));
        }

        return partyList;
    }

    public Party createParty(CreateEventRequestBody newEvent) {
        Party newParty = new Party();
        newParty.setPartyName(newEvent.getCreateParty().getPartyName());
        newParty.setDescription(newEvent.getCreateParty().getDescription());
        newParty.setPasscode(newEvent.getCreateParty().getPasscode());
        newParty.setCity(newEvent.getCreateParty().getCity());
        newParty.setStartDate(newEvent.getCreateParty().getStartDate());
        newParty.setStartTime(newEvent.getCreateParty().getStartTime());

        // Get current spotify user's id
        String currentSpotifyUserId = getCurrentSpotifyUserId();

        // Create new playlist
        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SpotifyCreatedPlaylist createdPlaylist = null;

        while (!success && tries < RETRY_COUNT) {
            createdPlaylist = spotifyApiService.createPlaylist(currentSpotifyUserId, newParty.getPartyName(), newParty.getDescription());
            if (createdPlaylist != null) {
                success = true;
            } else {
                tries++;
            }
        }

        // Set playlist id from created playlist to newParty object
        newParty.setPlaylistId(createdPlaylist.getId());

        // Add party to party table
        Party createdParty = partyService.create(newParty);

        // TODO create tags and then tag_party association
        String[] tagArray = newEvent.getCreateParty().getTheme().split(",");

        List<Tag> tagList = new ArrayList<>();

        tagList.add(new Tag(newEvent.getCreateParty().getCity()));
        tagList.add(new Tag(newEvent.getCreateParty().getPartyName()));

        for (String curTag : tagArray) {
            tagList.add(new Tag(curTag));
        }

        for (Tag thisTag : tagList) {
            if (tagService.getTagByName(thisTag.getTagNames()) == null) {
                try {
                    Tag newTag = tagService.create(thisTag);
                    int tagId = newTag.getTagId();
                    tagService.createTagParty(tagId, newParty.getPartyId());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else {

                Tag newTag = tagService.getTagByName(thisTag.getTagNames());
                int tagId = newTag.getTagId();

                if (!tagService.doesTagPartyExist(tagId, newParty.getPartyId())) {
                    tagService.createTagParty(tagId, newParty.getPartyId());
                }

            }
        }

        // TODO add party_id and user_id into party_user table
        partyService.createPartyUser(newParty.getPartyId(), newEvent.getUserId());

        return createdParty;
    }

    public String getCurrentSpotifyUserId() {

        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SpotifyUserProfile spotifyUserProfile = null;

        while (!success && tries < RETRY_COUNT) {
            spotifyUserProfile = spotifyApiService.getCurrentUserProfile();
            if (spotifyUserProfile != null) {
                success = true;
            } else {
                tries++;
            }
        }

        String currentSpotifyUserId = null;

        if (spotifyUserProfile != null) {
            currentSpotifyUserId = spotifyUserProfile.getId();
        }

        return currentSpotifyUserId;

    }

    public Tracks search(String term) {

        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SpotifySearchResults searchResults = null;

        while (!success && tries < RETRY_COUNT) {
            searchResults = spotifyApiService.search(term);
            if (searchResults != null) {
                success = true;
            } else {
                tries++;
            }
        }

        List<TrackInfo> searchedTrackInfoList = new ArrayList<>();

        if (searchResults != null) {
            for (Item track : searchResults.getTracks().getItems()) {
                TrackInfo newInfo = new TrackInfo();

                newInfo.setTrackId(track.getId());
                newInfo.setName(track.getName());
                newInfo.setArtist(track.getArtists().get(0).getName());
                newInfo.setImageUrl(track.getAlbum().getImages().get(2).getUrl());

                searchedTrackInfoList.add(newInfo);
            }
        }

        Tracks tracks = new Tracks();
        tracks.setTracks(searchedTrackInfoList);

        return tracks;

    }

    public SnapshotIdResponse addTrackToSpotifyPlaylist(int partyId, String trackId) {

        // Get playlistId from partyId
        String playlistId = getPlaylistIdFromPartyId(partyId);

        // Build URI string for track
        String trackUri = "spotify:track:" + trackId;

        // TODO: SHOULD CHECK IF SONG IS IN PLAYLIST ALREADY OR NOT, IF SO SEND AN ALERT THAT SONG IS ALREADY IN PLAYLIST

        // Add song to Spotify playlist
        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SnapshotIdResponse snapshotIdResponse = null;

        while (!success && tries < RETRY_COUNT) {
            snapshotIdResponse = spotifyApiService.addTrackToSpotifyPlaylist(playlistId, trackUri);
            if (snapshotIdResponse != null) {
                success = true;
            } else {
                tries++;
            }
        }

        // If song is in suggested song list, delete song from list
        if (partySongService.isSongInParty(partyId, trackId)) {
            try {
                partySongService.removeSongFromParty(partyId, trackId);
            } catch (Exception e) {
                System.out.println("Song with id: " + trackId + " doesn't exist in the suggested songs list.");
            }
        }

        return snapshotIdResponse;
    }

    public Tracks getSpotifyPlaylistSongs(int partyId) {

        // Get playlistId from partyId
        String playlistId = getPlaylistIdFromPartyId(partyId);

        // Get playlist songs from SpotifyApi HTTP GET method
        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SpotifyPlaylistSongs spotifyPlaylistSongs = null;

        while (!success && tries < RETRY_COUNT) {
            spotifyPlaylistSongs = spotifyApiService.getSpotifyPlaylistSongs(playlistId);
            if (spotifyPlaylistSongs != null) {
                success = true;
            } else {
                tries++;
            }
        }

        // Extract relevant song info into Track POJO
        List<TrackInfo> playlistSongs = new ArrayList<>();

        if (spotifyPlaylistSongs != null) {
            for (PlaylistItem item : spotifyPlaylistSongs.getItems()) {
                TrackInfo newInfo = new TrackInfo();

                newInfo.setTrackId(item.getTrack().getId());
                newInfo.setName(item.getTrack().getName());
                newInfo.setArtist(item.getTrack().getArtists().get(0).getName());
                newInfo.setImageUrl(item.getTrack().getAlbum().getImages().get(2).getUrl());

                playlistSongs.add(newInfo);
            }
        }

        Tracks tracks = new Tracks();
        tracks.setTracks(playlistSongs);

        return tracks;
    }

    public boolean addSongToSuggested(int partyId, Song songToAdd) throws Exception {

        String songId = songToAdd.getSongId();

        if (!songService.isSongInSongTable(songId)) {
            songService.create(songToAdd);
        }

        if (!partySongService.isSongInParty(partyId, songId)) {
            try {
                partySongService.addSongToParty(partyId, songId, 0);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }

        return true;
    }

    public SnapshotIdResponse deleteSongFromSpotifyPlaylist(int partyId, String songId) {

        // Get playlistId from partyId
        String playlistId = getPlaylistIdFromPartyId(partyId);

        // Delete song from Spotify playlist
        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SnapshotIdResponse snapshotIdResponse = null;

        while (!success && tries < RETRY_COUNT) {
            snapshotIdResponse = spotifyApiService.deleteSongFromSpotifyPlaylist(playlistId, songId);
            if (snapshotIdResponse != null) {
                success = true;
            } else {
                tries++;
            }
        }

        return snapshotIdResponse;
    }

    public void playSongFromSpotifyPlaylist(int partyId, String songId) {

        // get playlist id from party id
        String playlistId = getPlaylistIdFromPartyId(partyId);

        // Delete song from Spotify playlist
        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SnapshotIdResponse snapshotIdResponse = null;

        while (!success && tries < RETRY_COUNT) {
            snapshotIdResponse = spotifyApiService.playSongFromSpotifyPlaylist(playlistId, songId);
            if (snapshotIdResponse != null) {
                success = true;
            } else {
                tries++;
            }
        }

    }

    public CurrentlyPlaying getCurrentlyPlaying() {

        spotifyApiService.confirmTokenAvailable();

        boolean success = false;
        int tries = 0;

        SpotifyCurrentlyPlaying spotifyCurrentlyPlaying = null;

        while (!success && tries < RETRY_COUNT) {
            spotifyCurrentlyPlaying = spotifyApiService.getSpotifyCurrentlyPlaying();
            if (spotifyCurrentlyPlaying != null) {
                success = true;
            } else {
                tries++;
            }
        }

        // Extract relevant song info into POJO
        CurrentlyPlaying currentlyPlaying = new CurrentlyPlaying();

        if (spotifyCurrentlyPlaying != null) {
            currentlyPlaying.setPlaying(spotifyCurrentlyPlaying.getIsPlaying());
            currentlyPlaying.setName(spotifyCurrentlyPlaying.getItem().getName());
            currentlyPlaying.setArtist(spotifyCurrentlyPlaying.getItem().getArtists().get(0).getName());
            currentlyPlaying.setImageUrl(spotifyCurrentlyPlaying.getItem().getAlbum().getImages().get(2).getUrl());
        }

        return currentlyPlaying;
    }

    private String getPlaylistIdFromPartyId(int partyId) {
        Party party = partyService.getPartyById(partyId);
        return party.getPlaylistId();
    }

    public void deletePartyAndAssociated(int partyId) {
        partySongService.deleteByPartyId(partyId);
        partyService.deletePartyUserByPaartyId(partyId);
        tagService.deleteTagByPartyId(partyId);
        partyService.deleteByPartyId(partyId);
    }


}


