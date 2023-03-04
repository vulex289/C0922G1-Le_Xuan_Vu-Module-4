package com.example.cinema.dto;

import com.example.cinema.model.MovieName;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CinemaDto implements Validator {
    @NotBlank(message = "Không để trống")
    @Pattern(regexp = "^[M][V][-](\\d+)$")
    private String code;
    @NotBlank(message = "không để trống")
    private String dateCinema;
    @Min(value = 1)
    private int ticketCount;
    private MovieName movieName;
    private int status;

    public CinemaDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CinemaDto cinemaDto = (CinemaDto) target;
        String dateCinema = cinemaDto.getDateCinema();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateCinema, dateTimeFormatter);
        LocalDate now = LocalDate.now();
        if (date.isAfter(now)) {
            errors.rejectValue("dateCinema", "aa", "Ngày không được nhỏ hơn nhày hiện tải");
        }
    }
}
