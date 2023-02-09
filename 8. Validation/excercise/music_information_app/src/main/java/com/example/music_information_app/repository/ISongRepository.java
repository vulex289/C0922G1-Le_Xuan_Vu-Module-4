package com.example.music_information_app.repository;

import com.example.music_information_app.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}
