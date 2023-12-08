package com.techelevator.controller;

import com.techelevator.model.*;
import com.techelevator.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DataBaseController {

    private TagService tagService;
    private PartyService partyService;
    private PartySongService partySongService;
    private UserService userService;
    private AuxBoxService auxBoxService;

    public DataBaseController(TagService tagService, PartyService partyService, PartySongService partySongService, UserService userService, AuxBoxService auxBoxService) {
        this.tagService = tagService;
        this.partyService = partyService;
        this.partySongService = partySongService;
        this.userService = userService;
        this.auxBoxService = auxBoxService;
    }

    @GetMapping("/party/tag/{tagName}")
    public List<Party> getPartyByTagName(@PathVariable String tagName) throws Exception {
        Tag tag = tagService.getTagByName(tagName);

        if (tag != null) {
            return partyService.getPartyByTagId(tag.getTagId());

        } else {
            throw new Exception("No party for " + tagName + " was found.");
        }
    }

    /* TODO
        Method to display suggested song list to front end (GUEST AND DJ)
        HTTP GET method that gets all suggested songs associated with the party
            Ex: "/party/{party_id}/suggested
        Controller method return type: Array of songs with properties: song_id, song_name, artist, imageUrl
        Within service:
            1. Get all songs and their details from party_song table using the PartySongService
                Note: will probably require a DAO method that utilizes a JOIN of song and party_song table
     */
    @GetMapping("/party/{partyId}/suggested")
    public List<SuggestedSong> getSuggestedSongsByPartyId(@PathVariable int partyId) throws Exception {
        Party party = partyService.getPartyById(partyId);

        if (party != null) {
            return partySongService.getSuggestedSongsByPartyId(partyId);
        } else {
            throw new Exception("Party with id (" + partyId + ") does not exists.");
        }
    }

    @GetMapping("/party/{partyId}")
    public Party getPartyByPartyId(@PathVariable int partyId) throws Exception {
        Party party = partyService.getPartyById(partyId);

        if (party != null) {
            return party;
        } else {
            throw new Exception("Party with id (" + partyId + ") does not exists.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/party/{partyId}/suggested")
    public void deleteSongFromSuggested(@PathVariable int partyId, @RequestParam(name = "id", required = true) String songId) throws Exception {
        partySongService.removeSongFromParty(partyId, songId);
    }

    @PostMapping("/tagparty/{tagId}/{partyId}")
    public void createTagParty(@PathVariable int tagId, @PathVariable int partyId) {
        tagService.createTagParty(tagId, partyId);
    }

    @GetMapping("/party/user/{userId}")
    public List<Party> getPartyListByUserId(@PathVariable int userId) throws Exception {
        try {
            return auxBoxService.getPartiesByUserId(userId);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/party/{partyId}")
    public void deletePartyAndAssociated(@PathVariable int partyId) {
        auxBoxService.deletePartyAndAssociated(partyId);
    }

    @PutMapping("/party/{partyId}/suggested/{songId}/upvote")
    public void upVoteSongFromSuggested(@PathVariable int partyId, @PathVariable String songId) {
        partySongService.upVoteSongFromSuggested(partyId, songId);
    }

    @PutMapping("/party/{partyId}/suggested/{songId}/downvote")
    public void downVoteSongFromSuggested(@PathVariable int partyId, @PathVariable String songId) {
        partySongService.downVoteSongFromSuggested(partyId, songId);
    }


}
