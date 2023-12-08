package com.techelevator.services;

import
com.techelevator.dao.SongDao;
import com.techelevator.model.PartySong;
import com.techelevator.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService {

    private final SongDao songDao;

    public SongService(SongDao songDao) {
        this.songDao = songDao;
    }
    public List<Song> getAll() {
        return songDao.getAll();
    }

    public Song getSongById(String songId) throws Exception {
        return songDao.getSongById(songId);
    }

    public Song getSongByName(String songName) {
        return songDao.getSongName(songName);
    }

    public Song create(Song song) throws Exception {
        return songDao.create(song);
    }

    public void update(Song song) {
        songDao.update(song);
    }

    public void delete(String songID) {
        songDao.delete(songID);
    }

    public boolean isSongInSongTable(String songId) {
        try {
            Song result = getSongById(songId);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}



