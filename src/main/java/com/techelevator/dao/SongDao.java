package com.techelevator.dao;

import com.techelevator.model.Song;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface SongDao {

   List<Song> getAll();

    Song getSongName(String name);

    Song getSongById(String songId) throws Exception;

    Song create(Song song) throws Exception;


    void delete(String songId);

    void update(Song song);
}
