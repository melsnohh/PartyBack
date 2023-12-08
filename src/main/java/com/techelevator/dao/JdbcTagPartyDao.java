package com.techelevator.dao;

import com.techelevator.model.Tag;
import com.techelevator.model.TagParty;
import com.techelevator.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcTagPartyDao implements TagPartyDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTagPartyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TagParty getTagPartyByIds(int tagId, int partyId) {
        String sql = "SELECT * FROM tag_party WHERE tag_id = ? AND party_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tagId, partyId);
        if (results.next()) {
            TagParty tagParty = new TagParty();
            tagParty.setTagId(results.getInt("tag_id"));
            tagParty.setPartyId(results.getInt("party_id"));
            return tagParty;
        } else {
            return null;
        }
    }



    @Override
    public void create(int tagId, int partyId) {
        String sql = "INSERT INTO tag_party (tag_id, party_id) VALUES (?, ?)";
            jdbcTemplate.update(sql, tagId, partyId);
    }

    @Override
    public void deleteByPartyId(int partyId) {
        String sql = "DELETE FROM tag_party WHERE party_id = ?";
        jdbcTemplate.update(sql, partyId);
    }

}
