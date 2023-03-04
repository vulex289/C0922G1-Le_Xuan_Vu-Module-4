package com.example.cinema.service;

import com.example.cinema.model.Cinema;
import com.example.cinema.repository.ICinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CinemaService implements ICinemaService {
    @Autowired
    private ICinemaRepository cinemaRepository;

    @Override
    public Page<Cinema> getAll(Pageable pageable, String date) {
        return cinemaRepository.getAll(pageable, date);
    }

    @Override
    public Page<Cinema> getAllByNameMovie(Pageable pageable, String date, long id) {
        return cinemaRepository.getAllByNameCinema(pageable, date, id);
    }

    @Override
    public void save(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    @Override
    public void edit(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    @Override
    public void deleteById(String code) {
        cinemaRepository.deleteById(code);
    }

    @Override
    public Cinema findById(String code) {
        return cinemaRepository.findById(code).orElse(null);
    }
}
