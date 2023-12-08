package com.techelevator.dao;

import com.techelevator.model.PartySong;
import com.techelevator.model.SuggestedSong;

import java.util.List;

public interface PartySongDao {

     void create(int partyId, String songId, int vote) throws Exception;

     boolean delete(int partyId, String songId);

     PartySong getPartySongByPartyIdAndSongId(int partyId, String trackId);

     List<SuggestedSong>  getSuggestedSongsByPartyId(int partyId);

     void deleteByPartyId(int partyId);

     void upVoteSongFromSuggested(int partyId, String songId);

     void downVoteSongFromSuggested(int partyId, String songId);

}
