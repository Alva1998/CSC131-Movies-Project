package com.example.moviepractice.Controller;
import com.example.moviepractice.Model.Movie;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import OMDB file for use below

import java.util.concurrent.atomic.AtomicLong;

import OmdbApi.OmdbController;
import OmdbApi.OmdbWebServiceClient;
import OmdbApi.OmdbController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//want to be json so use RestController
@RestController
public class MovieRestController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    //filter json function
    // public String filterJson(String response) throws JsonParseException {
    //     List<String> filtered = new ArrayList<>();
    //     JSONARRAy
    // } 

    //only returns the title
    //http://localhost:8080/movies?title="INSERT TITLE HERE"
    @GetMapping("/award")
    Movie title(@RequestParam(defaultValue = "null") String title) {
        String inputTitle = "{parasite}";
        String response = OmdbWebServiceClient.searchMovieByTitle(inputTitle, "fe57eabc");
        OmdbController test = new OmdbController(response);


        return new Movie(counter.incrementAndGet(), test.getJsonResponse(), String.format(template, title), 0);
        // return new Movie(counter.incrementAndGet(), String.format(template, title), test.getJsonResponse(), 0);
    }
    
    @RequestMapping("/movies/{title}")
    public @ResponseBody String getResponse(@PathVariable(value="title") String titles) {
        String response = OmdbWebServiceClient.searchMovieByTitle(titles, "fe57eabc");
        OmdbController test = new OmdbController(response);
        return test.getJsonResponse();
    }

    // String response = OmdbWebServiceClient.SEARCH_BY_IMDB_URL;

    // @RequestMapping("/movies/{title}")
    // public @ResponseBody String getResponse(@PathVariable(value="title") String titles) {
    //     String response = OmdbWebServiceClient.SEARCH_BY_IMDB_URL;
    //     OmdbController test = new OmdbController(response);
    //     return test.getJsonResponse();
    // }
}
