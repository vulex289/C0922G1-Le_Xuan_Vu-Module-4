package com.example.music_information_app.service;

import com.example.music_information_app.model.Song;
import org.apache.catalina.User;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(int id);
}
