package com.techelevator.controller;

import com.techelevator.domain.Tracks;
import com.techelevator.domain.CurrentlyPlaying;
import com.techelevator.domain.spotify.SnapshotIdResponse;
import com.techelevator.model.CreateEventRequestBody;
import com.techelevator.model.Party;
import com.techelevator.model.Song;
import com.techelevator.services.AuxBoxService;
import com.techelevator.services.SpotifyApiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
//@PreAuthorize("isAuthenticated")
public class AuxBoxController {

    private SpotifyApiService spotifyApiService;
    private AuxBoxService auxBoxService;

    public AuxBoxController(SpotifyApiService spotifyApiService, AuxBoxService auxBoxService) {
        this.spotifyApiService = spotifyApiService;
        this.auxBoxService = auxBoxService;
    }

    // Request Body includes: party_name, description, passcode, city, start_date, start_time
    // TODO need to add tags and user id
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/party")
    public void createParty(@RequestBody CreateEventRequestBody newEvent, HttpServletResponse httpServletResponse) {
        Party response = auxBoxService.createParty(newEvent);
        // Implement the following, so once the method is done, redirect to DJ home page
//        if (response != null) {
//            httpServletResponse.setHeader("Location", "http://localhost:8080/DJhomepage");
//            httpServletResponse.setStatus(302);
//        }
    }

    @GetMapping("/search")
    public Tracks search(@RequestParam(required = true) String term) {
        return auxBoxService.search(term);
    }

    /* TODO
        Method to add a song from search to suggested list (GUEST ONLY)
        HTTP POST that receives song object and party_id from the front end
        Controller method return type: void
        Within service:
            1. Check to see if song already exists in song table. If exists, skip to 3
            2. If DNE, add song to song table
            3. Add song_id and party_id relationship to the party_song table
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/party/{partyId}/suggested")
    public void addSongToSuggested(@PathVariable int partyId, @RequestBody Song songToAdd) throws Exception {

        try {
            auxBoxService.addSongToSuggested(partyId, songToAdd);
//            if (addedSong != null) {
//                httpServletResponse.setHeader("Location", "http://localhost:8080/party/" + partyId);
//                httpServletResponse.setStatus(302);
//            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    /* TODO
        Method to add song from search results list OR suggested song list to Spotify Playlist (DJ ONLY)
        HTTP POST method that receives song_id and party_id from the front end
        Controller method return type: void
            1. Get playlist_id from party_id using PartyService
            2. Build URI string (ex: "spotify:track" + song_id)
            3. Add song to Spotify playlist using SpotifyApi HTTP POST method
            4. If successful, delete song from suggested song list (delete song from party_song) using PartyService
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/party/{partyId}/playlist/track")
    public void addTrackToSpotifyPlaylist(@PathVariable int partyId, @RequestParam(name = "id", required = true) String trackId, HttpServletResponse httpServletResponse) {
        SnapshotIdResponse response = auxBoxService.addTrackToSpotifyPlaylist(partyId, trackId);
    }

    /* TODO
        Method to display songs from Spotify Playlist (GUEST and DJ)
        HTTP GET method to get all tracks from Spotify Playlist associate with the party
        Controller receives party_id from front end
        Controller method return type: Array of songs with properties: song_id, song_name, artist, imageUrl
            1. Get playlist_id from party_id using PartyService
            2. Get playlist info from SpotifyApi HTTP GET method
                2.1 Map JSON response into POJO
                2.2 Extract relevant song info into TrackInfo POJO
            3. Return array of TrackInfo POJOs to the front end
     */
    @GetMapping("/party/{partyId}/playlist")
    public Tracks getSpotifyPlaylistSongs(@PathVariable int partyId) {
        return auxBoxService.getSpotifyPlaylistSongs(partyId);
    }

    /* TODO
        Method to delete a song from the Spotify Playlist (DJ ONLY)
        HTTP DELETE method that receives song_id and party_id from the front end
        Controller method return type: void
            1. Get playlist_id from party_id using PartyService
            2. Build request body
                2.1 uri string ex: "spotify:track:"+song_id;
                2.2 request body needs to be an array of tracks. ex: { "track": { "uri": [URI STRING GOES HERE] } }
            3. Call SpotifyApiService to send a HTTP DELETE request to /playlists/{playlist_id}/tracks with request body
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/party/{partyId}/playlist/track")
    public void deleteSongFromSpotifyPlaylist(@PathVariable int partyId, @RequestParam(name = "id", required = true) String songId) {
        SnapshotIdResponse response = auxBoxService.deleteSongFromSpotifyPlaylist(partyId, songId);
    }


    /* TODO
        LOWER PRIORITY METHODS
        Methods to:
            add song to queue (DJ ONLY)
            display current playing song (GUEST AND DJ)
            play song (DJ ONLY)
            pause song (DJ ONLY)
            go to next song (DJ ONLY)
            go to previous song (DJ ONLY)
     */
    @PutMapping("/playlist/play")
    public void playSpotifyPlaylist() {
        spotifyApiService.playSpotifyPlaylist();
    }

    @PutMapping("/party/{partyId}/playlist/play")
    public void playSongFromSpotifyPlaylist(@PathVariable int partyId, @RequestParam(name = "id", required = true) String songId) {
        auxBoxService.playSongFromSpotifyPlaylist(partyId, songId);
    }

    @PutMapping("/playlist/pause")
    public void pauseSpotifyPlaylist() {
        spotifyApiService.pauseSpotifyPlaylist();
    }

    @PostMapping("/playlist/next")
    public void nextSpotifyPlaylist() {
        spotifyApiService.nextSpotifyPlaylist();
    }

    @PostMapping("/playlist/previous")
    public void previousSpotifyPlaylist() {
        spotifyApiService.previousSpotifyPlaylist();
    }

    @GetMapping("/playlist/currently-playing")
    public CurrentlyPlaying getCurrentlyPlaying() {
        return auxBoxService.getCurrentlyPlaying();
    }


}
