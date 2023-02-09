package com.example.music_information_app.model;

import javax.validation.constraints.*;

public class SongDto {
    private int id;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 800,message = "Số kí tự không quá 800 kí tự")
    @Pattern(regexp = "^([\\p{L}\\s]|\\w\\W\\d|[,]|[!]|[?][.])+$",message = "Không đúng định dạng")
    @NotBlank(message = "Không được chứa kí tự bắt đầu bằng dấu cách")
    private String name;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 300,message = "Số kí tự không quá 300 kí tự")
    @Pattern(regexp = "^([\\p{L}\\s]|\\w\\W\\d|[,])+$",message = "Không đúng định dạng")
    @NotBlank(message = "Không được chứa kí tự bắt đầu bằng dấu cách")
    private String singer;
    @Size(max = 1000,message = "Số kí tự không quá 800 kí tự")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^([\\p{L}\\s]|\\w\\W\\d)+$",message = "Không đúng định dạng")
    @NotBlank(message = "Không được chứa kí tự bắt đầu bằng dấu cách")
    private String title;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String title) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
