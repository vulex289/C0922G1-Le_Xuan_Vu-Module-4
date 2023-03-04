package com.example.cinema.repository;

import com.example.cinema.model.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICinemaRepository extends JpaRepository<Cinema,String> {
    @Query(value = "select * from cinema where date_cinema like concat('%',:param,'%')",nativeQuery = true)
    Page<Cinema> getAll(Pageable pageable, @Param("param") String dateCinema);
    @Query(value = "select * from cinema where date_cinema like concat('%',:param,'%') and movie_name_id=:id",nativeQuery = true)
    Page<Cinema> getAllByNameCinema(Pageable pageable, @Param("param") String dateCinema,@Param("id") long id);
}
