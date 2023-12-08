package com.techelevator.dao;

import com.techelevator.model.Party;

import java.util.List;

public interface PartyDao {

    List<Party> getAll();
    Party getPartyById(int id);
    Party create(Party party);

    List<Party> getPartyByTagId(int tagId);

    void deletePartyById(int partyId);

    void updateParty(Party party);


}
