package com.techelevator.dao;

import com.techelevator.model.PartyUserDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPartyUserDao implements PartyUserDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPartyUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void create(int partyId, int userId) {
        String sql = "INSERT INTO party_user (party_id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, partyId, userId);
    }

    @Override
    public List<Integer> getPartyIdsByUser(int userId) {
        List<Integer> partyIds = new ArrayList<>();
        String sql = "SELECT * FROM party_user WHERE user_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        while (result.next()) {
            PartyUserDTO resultDTO = mapRowToPartyUserDTO(result);
            partyIds.add(resultDTO.getPartyId());
        }
        return partyIds;
    }

    @Override
    public void delete(int partyId) {
        String sql = "DELETE FROM party_user WHERE party_id = ?";
        jdbcTemplate.update(sql, partyId);
    }

    public PartyUserDTO mapRowToPartyUserDTO(SqlRowSet result) {
        PartyUserDTO partyUserDTO = new PartyUserDTO();

        partyUserDTO.setPartyId(result.getInt("party_id"));
        partyUserDTO.setUserId(result.getInt("user_id"));

        return partyUserDTO;
    }




}
