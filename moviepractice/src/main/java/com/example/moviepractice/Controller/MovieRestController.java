package com.example.moviepractice.Controller;
import com.example.moviepractice.Model.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import OMDB file for use below

import java.util.concurrent.atomic.AtomicLong;

//want to be json so use RestController
@RestController
public class MovieRestController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    //only returns the title
    //http://localhost:8080/movies?title="INSERT TITLE HERE"
    @GetMapping("/movies")
    Movie title(@RequestParam(defaultValue = "null") String title) {
        return new Movie(counter.incrementAndGet(), String.format(template, title), "null", 0);
    }
}
