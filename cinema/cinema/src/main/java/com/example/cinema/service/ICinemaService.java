package com.example.cinema.service;

import com.example.cinema.model.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICinemaService {
    Page<Cinema> getAll(Pageable pageable, String date);
    Page<Cinema> getAllByNameMovie(Pageable pageable, String date, long id);
    void save(Cinema cinema);
    void edit(Cinema cinema);
    void deleteById(String code);
    Cinema findById(String code);
}
