package com.techelevator.dao;

import com.techelevator.model.Tag;

import java.util.List;

public interface TagDao {

    List<Tag> getAll();
    Tag getTagByName(String name);
    Tag create(Tag tag) throws Exception;
    Tag getTagById(int tagid);

    boolean delete(int tagId);

    boolean update(Tag tag);
}
