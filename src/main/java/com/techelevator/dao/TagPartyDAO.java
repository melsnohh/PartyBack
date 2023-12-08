package com.techelevator.dao;

import com.techelevator.model.TagParty;

import java.util.List;

public interface TagPartyDAO {

    TagParty getTagPartyByIds(int tagId, int partyId);

    void create(int tagId, int partyId);

    void deleteByPartyId(int partyId);

}
