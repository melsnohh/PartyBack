package com.techelevator.dao;

import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSongDao implements SongDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSongDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Song> getAll() {
        ArrayList<Song> songs = new ArrayList<>();

        String sql = "SELECT * FROM song";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            songs.add(mapRowToSong(rows));
        }

        return songs;
    }

    @Override
    public Song getSongName(String songName) {
        if (songName == null) throw new IllegalArgumentException("songName cannot be null");
        Song song = null;

        String sql = "Select * FROM song WHERE song_name = ?";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, songName);

        if (row.next()) {
            song = mapRowToSong(row);
            return song;
        }

        throw new NullPointerException("Song: " + songName + " was not found.");
    }

    @Override
    public Song getSongById(String songId) throws Exception {

        Song song = null;

        String sql = "Select * FROM song WHERE song_id = ?";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, songId);

        if (row.next()) {
            song = mapRowToSong(row);
            return song;
        }

        throw new Exception("Song at ID: " + songId + " was not found.");
    }

    @Override
    public Song create(Song song) throws Exception {
        String sql = "INSERT INTO song (song_id, song_name, artist, image_url) VALUES (?,?,?,?) RETURNING song_id;";
        try {
            String songId = jdbcTemplate.queryForObject(sql, String.class, song.getSongId(), song.getSongName(), song.getArtist(), song.getImageUrl());
            return song;
        } catch (Exception ex) {
            throw new Exception("put a valid song");
        }
    }

    @Override
    public void delete(String songId) {
        String sql = "DELETE FROM song WHERE song_id = ?";
        jdbcTemplate.update(sql, songId);
    }

    @Override
    public void update(Song song) {
        String sql = "UPDATE song SET song_name = ?, artist = ?, image_url = ? WHERE song_id = ?";
        jdbcTemplate.update(sql, song.getSongName(), song.getArtist(), song.getImageUrl(), song.getSongId());
    }

    private Song mapRowToSong(SqlRowSet row) {
        Song song = new Song();

        song.setSongId(row.getString("song_id"));
        song.setSongName(row.getString("song_name"));
        song.setArtist(row.getString("artist"));
        song.setImageUrl(row.getString("image_url"));

        return song;
    }


}
