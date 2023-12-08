package com.techelevator.dao;

import com.techelevator.model.Party;
import com.techelevator.model.PartySong;
import com.techelevator.model.Song;
import com.techelevator.model.SuggestedSong;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPartySongDao implements PartySongDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPartySongDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(int partyId, String songId, int vote) throws Exception {
        String sql = "INSERT INTO party_song (party_id, song_id, vote) values (?,?,?)";
        jdbcTemplate.update(sql, partyId, songId, vote);
    }

    @Override
    public boolean delete(int partyId, String songId) {
        String sql = "DELETE FROM party_song WHERE party_id = ? AND song_id = ?";
        int row = jdbcTemplate.update(sql, partyId, songId);
        return row > 0;
    }

    @Override
    public PartySong getPartySongByPartyIdAndSongId(int partyId, String trackId) {
        String sql = "SELECT * FROM party_song WHERE party_id = ? AND song_id = ?";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, partyId, trackId);

        if (row.next()) {
            PartySong partySong = new PartySong();
            partySong.setPartyId(row.getInt("party_id"));
            partySong.setSongId(row.getString("song_id"));
            partySong.setVote(row.getInt("vote"));
            return partySong;
        }

        return null;
    }

    public List<SuggestedSong> getSuggestedSongsByPartyId(int partyId) {

        List<SuggestedSong> suggestedSongs = new ArrayList<>();

        String sql = "SELECT s.song_id, song_name, artist, image_url, vote FROM song s " +
                "JOIN party_song ps ON s.song_id = ps.song_id WHERE party_id = ? ORDER BY vote DESC";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, partyId);

        while (rowSet.next()) {
            SuggestedSong suggestedSong = mapRowToSuggestedSong(rowSet);
            suggestedSongs.add(suggestedSong);
        }

        return suggestedSongs;

    }

    @Override
    public void deleteByPartyId(int partyId) {
        String sql = "DELETE FROM party_song WHERE party_id = ?";
        jdbcTemplate.update(sql, partyId);
    }

    public void upVoteSongFromSuggested(int partyId, String songId) {
        String sql = "UPDATE party_song SET vote = vote + 1 WHERE party_id = ? AND song_id = ?";
        jdbcTemplate.update(sql, partyId, songId);
    }

    public void downVoteSongFromSuggested(int partyId, String songId) {
        String sql = "UPDATE party_song SET vote = vote - 1  WHERE party_id = ? AND song_id = ?";
        jdbcTemplate.update(sql, partyId, songId);
    }

    private SuggestedSong mapRowToSuggestedSong(SqlRowSet rs) {
        SuggestedSong suggestedSong = new SuggestedSong();

        suggestedSong.setSongId(rs.getString("song_id"));
        suggestedSong.setArtist(rs.getString("artist"));
        suggestedSong.setSongName(rs.getString("song_name"));
        suggestedSong.setImageUrl(rs.getString("image_url"));
        suggestedSong.setVote(rs.getInt("vote"));

        return suggestedSong;
    }



}
