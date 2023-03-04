package com.example.cinema.service;

import com.example.cinema.model.MovieName;
import com.example.cinema.repository.IMovieNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieNameService implements IMoiveNameService{
    @Autowired
    private IMovieNameRepository movieNameRepository;
    @Override
    public List<MovieName> findAll() {
        return movieNameRepository.findAll();
    }
}
