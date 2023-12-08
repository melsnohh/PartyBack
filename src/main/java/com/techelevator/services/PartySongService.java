package com.techelevator.services;

import com.techelevator.dao.PartySongDao;
import com.techelevator.model.PartySong;
import com.techelevator.model.SuggestedSong;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartySongService {
    private final PartySongDao partySongDao;

    public PartySongService(PartySongDao partySongDao) {
        this.partySongDao = partySongDao;
    }

    public void addSongToParty(int partyId, String songId, int vote) throws Exception {
        try {
            partySongDao.create(partyId, songId, vote);
        } catch (Exception e) {
            throw new Exception("Error adding song to party", e);
        }
    }

    public void removeSongFromParty(int partyId, String songId) throws Exception {
        boolean success = partySongDao.delete(partyId, songId);
        if (!success) {
            throw new Exception("Song not found for party");
        }
    }

    public boolean isSongInParty(int partyId, String trackId) {
        PartySong result = partySongDao.getPartySongByPartyIdAndSongId(partyId, trackId);
        return result != null;
    }

    public List<SuggestedSong> getSuggestedSongsByPartyId(int partyId) {
        return partySongDao.getSuggestedSongsByPartyId(partyId);
    }

    public void deleteByPartyId(int partyId) {
        partySongDao.deleteByPartyId(partyId);
    }

    public void upVoteSongFromSuggested(int partyId, String songId) {
        partySongDao.upVoteSongFromSuggested(partyId, songId);
    }

    public void downVoteSongFromSuggested(int partyId, String songId) {
        partySongDao.downVoteSongFromSuggested(partyId, songId);
    }


}
