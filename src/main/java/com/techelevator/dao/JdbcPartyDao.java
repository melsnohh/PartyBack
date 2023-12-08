package com.techelevator.dao;

import com.techelevator.model.Party;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPartyDao implements PartyDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPartyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Party> getAll() {

        List<Party> parties = new ArrayList<>();

        String sql = "SELECT * FROM party";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            Party party = mapRowToParty(result);
            parties.add(party);
        }

        return parties;
    }

    @Override
    public Party getPartyById(int id) {
        String sql = "SELECT * FROM party WHERE party_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToParty(results);
        }
        return null;
    }

    @Override
    public Party create(Party party) {

        String sql = "INSERT INTO party (party_name, description, passcode, playlist_id," +
                "city, start_date, start_time) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?) " +
                "returning party_id";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, party.getPartyName(),
                party.getDescription(), party.getPasscode(), party.getPlaylistId(),
                party.getCity(), party.getStartDate(), party.getStartTime());

        party.setPartyId(id);
        return party;
    }

    @Override
    public List<Party> getPartyByTagId(int tagId) {

        List<Party> parties = new ArrayList<>();

//        Need to Join the tag_party with Party

        String sql = "SELECT * FROM party p " +
                "JOIN tag_party tp ON " +
                "p.party_id = tp.party_id" +
                " WHERE tag_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, tagId);

        while (result.next()) {
            Party party = mapRowToParty(result);
            parties.add(party);
        }

        return parties;
    }

    @Override
    public void deletePartyById(int partyId) {
        String sql = "DELETE FROM party WHERE party_id = ?";
        jdbcTemplate.update(sql, partyId);
    }

    @Override
    public void updateParty(Party party) {
        String sql = "UPDATE party SET party_name = ?, description = ?, passcode = ?, " +
                "playlist_id = ?, city = ?, start_date = ?, start_time = ? WHERE party_id = ?";

        jdbcTemplate.update(sql, party.getPartyName(), party.getDescription(), party.getPasscode(),
                party.getPlaylistId(), party.getCity(), party.getStartDate(), party.getStartTime(),
                party.getPartyId());
    }


    private Party mapRowToParty(SqlRowSet rs) {
        Party party = new Party();

        party.setPartyId(rs.getInt("party_id"));
        party.setPartyName(rs.getString("party_name"));
        party.setDescription(rs.getString("description"));
        party.setPasscode(rs.getString("passcode"));
        party.setPlaylistId(rs.getString("playlist_id"));
        party.setCity(rs.getString("city"));
        party.setStartDate(rs.getDate("start_date").toLocalDate());
        party.setStartTime(rs.getTime("start_time").toLocalTime());

        return party;
    }
}
