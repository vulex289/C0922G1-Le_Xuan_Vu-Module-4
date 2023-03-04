package com.example.cinema.model;

import javax.persistence.*;

@Entity
public class Cinema {
    @Id
    private String code;
    @Column(columnDefinition = "date")
    private String dateCinema;
    private int ticketCount;
    @ManyToOne
    @JoinColumn(name = "movie_name_id",referencedColumnName = "id")
    private MovieName movieName;
    private int status;

    public Cinema() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateCinema() {
        return dateCinema;
    }

    public void setDateCinema(String dateCinema) {
        this.dateCinema = dateCinema;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public MovieName getMovieName() {
        return movieName;
    }

    public void setMovieName(MovieName movieName) {
        this.movieName = movieName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
