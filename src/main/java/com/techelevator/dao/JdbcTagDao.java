package com.techelevator.dao;

import com.techelevator.dao.TagDao;
import com.techelevator.model.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTagDao implements TagDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTagDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tag> getAll() {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT * FROM tag";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            Tag tag = mapRowToTag(rows);
            tags.add(tag);
        }
        return tags;
    }

    @Override
    public Tag getTagByName(String name) {
        String sql = "SELECT * FROM tag WHERE LOWER(tag_names) LIKE ?";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, name.toLowerCase());
        if (row.next()) {
            return mapRowToTag(row);
        }

        return null;
    }

    @Override
    public Tag create(Tag tag) throws RuntimeException {
        String sql = "INSERT INTO tag (tag_names) VALUES (?) RETURNING tag_id";
        try {
            Integer tagID = jdbcTemplate.queryForObject(sql, Integer.class, tag.getTagNames());
            if (tagID != null) {
                tag.setTagId(tagID);
            }
        } catch (DataAccessException ex) {
            throw new RuntimeException("error creating tag:" + tag.getTagNames(), ex);
        }
        return tag;
    }

    @Override
    public Tag getTagById(int tagid) {
        String sql = "SELECT * FROM tag WHERE tag_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, tagid);
        if (row.next()) {
            return mapRowToTag(row);
        }

        return null;
    }

    @Override
    public boolean delete(int tagId) {
        String sql = "DELETE FROM tag WHERE tag_id = ?";
        return jdbcTemplate.update(sql, tagId) == 1;
    }

    @Override
    public boolean update(Tag tag) {
        String sql = "UPDATE tag SET tag_names = ? WHERE tag_id = ?";
        return jdbcTemplate.update(sql, tag.getTagNames(), tag.getTagId()) == 1;
    }

    private Tag mapRowToTag(SqlRowSet rs) {
        Tag tag = new Tag();
        tag.setTagId(rs.getInt("tag_id"));
        tag.setTagNames(rs.getString("tag_names"));
        return tag;
    }
}
