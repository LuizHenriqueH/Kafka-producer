package com.live.kafka.cinemaProducer.controller;

import com.live.kafka.cinemaProducer.producer.CinemaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;


@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    CinemaProducer cinemaProducer;

    @PostMapping("/send")
    public ResponseEntity<CinemaDTO> sendMessage(@RequestBody CinemaDTO cinemaDTO) {
        CinemaDTO cinema = CinemaDTO.builder()
                .id(UUID.randomUUID())
                .movieTitle(cinemaDTO.getMovieTitle())
                .genre(cinemaDTO.getGenre())
                .year(cinemaDTO.getYear())
                .director(cinemaDTO.getDirector())
                .classification(cinemaDTO.getClassification())
                .imdbPage(cinemaDTO.getImdbPage())
                .build();

        cinemaProducer.send(cinema);
        return ResponseEntity.status(HttpStatus.CREATED).body(cinema);

    }
}
