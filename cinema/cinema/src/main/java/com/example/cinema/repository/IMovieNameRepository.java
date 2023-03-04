package com.example.cinema.repository;

import com.example.cinema.model.MovieName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieNameRepository extends JpaRepository<MovieName,Long> {
}
