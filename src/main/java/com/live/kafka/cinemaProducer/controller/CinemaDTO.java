package com.live.kafka.cinemaProducer.controller;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CinemaDTO {

    private UUID id;
    private String movieTitle;
    private String genre;
    private String year;
    private String director;
    private String classification;
    private String imdbPage;

}
