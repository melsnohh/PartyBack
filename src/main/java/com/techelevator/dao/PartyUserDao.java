package com.techelevator.dao;

import org.springframework.stereotype.Component;

import java.util.List;

public interface PartyUserDao {

    void create(int partyId, int userId);

    List<Integer> getPartyIdsByUser(int userId);

    void delete(int partyId);


}


