package com.techelevator.services;

import com.techelevator.dao.TagDao;
import com.techelevator.dao.TagPartyDAO;
import com.techelevator.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private  final TagDao tagDao;
    private final TagPartyDAO tagPartyDao;

    public TagService(TagDao tagDao, TagPartyDAO tagPartyDao) {
        this.tagDao = tagDao;
        this.tagPartyDao = tagPartyDao;
    }

    public List<Tag> getAll() {
        return tagDao.getAll();
    }

    public Tag getTagById(int tagid){return  tagDao.getTagById(tagid);}

    public Tag getTagByName(String name) {
        return tagDao.getTagByName(name);
    }


    public Tag create(Tag tag) throws Exception {
        return tagDao.create(tag);
    }


    public void update(Tag tag) {
        tagDao.update(tag);
    }


    public void delete(int tag) {
        tagDao.delete(tag);
    }

    public void createTagParty(int tagId, int partyId) {
        tagPartyDao.create(tagId, partyId);
    }

    public boolean doesTagPartyExist(int tagId, int partyId) {
        return (tagPartyDao.getTagPartyByIds(tagId, partyId) != null);
    }

    public void deleteTagByPartyId(int partyId) {
        tagPartyDao.deleteByPartyId(partyId);
    }

}
