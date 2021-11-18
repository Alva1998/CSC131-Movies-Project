package com.example.moviepractice.Controller;
import com.example.moviepractice.Model.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import OMDB file for use below

import java.util.concurrent.atomic.AtomicLong;

import OmdbApi.OmdbController;
import OmdbApi.OmdbWebServiceClient;
import OmdbApi.OmdbController;
import java.util.Scanner;

//want to be json so use RestController
@RestController
public class MovieRestController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    //only returns the title
    //http://localhost:8080/movies?title="INSERT TITLE HERE"
    @GetMapping("/movies")
    Movie title(@RequestParam(defaultValue = "null") String title) {
        String inputTitle = "whiplash";
        String response = OmdbWebServiceClient.searchMovieByTitle(inputTitle, "fe57eabc");
        OmdbController test = new OmdbController(response);
        return new Movie(counter.incrementAndGet(), test.getJsonResponse(), String.format(template, title), 0);
        // return new Movie(counter.incrementAndGet(), String.format(template, title), test.getJsonResponse(), 0);
    }
}
