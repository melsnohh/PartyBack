package com.techelevator.services;

import com.techelevator.dao.PartyDao;
import com.techelevator.dao.PartyUserDao;
import com.techelevator.model.Party;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

    private final PartyDao partyDao;
    private final PartyUserDao partyUserDao;

    public PartyService(PartyDao partyDao, PartyUserDao partyUserDao) {
        this.partyDao = partyDao;
        this.partyUserDao = partyUserDao;
    }

    public List<Party> getAll() {
        return partyDao.getAll();
    }

    public List<Party> getPartyByTagId(int tagId){return partyDao.getPartyByTagId(tagId);}

    public Party getPartyById(int id) {
        return partyDao.getPartyById(id);
    }

    public Party create(Party party) {
        return partyDao.create(party);
    }

    public void update(Party party) {
        partyDao.updateParty(party);
    }

//    public void delete(Party party) {
//        partyDao.deletePar(party);
//    }

    public void deleteByPartyId(int partyId) {
        partyDao.deletePartyById(partyId);
    }

    public void createPartyUser(int partyId, int userId) {
        partyUserDao.create(partyId, userId);
    }

    public List<Integer> getPartyIdsByUser(int userId) {
        return partyUserDao.getPartyIdsByUser(userId);
    }

    public void deletePartyUserByPaartyId(int partyId) {
        partyUserDao.delete(partyId);
    }

}


