package com.javabrains.microservices.movieinfoservice.controller;

import com.javabrains.microservices.movieinfoservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksandar on Jan, 2020
 */

@RestController
@RequestMapping("movie-info")
public class MovieInfoController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable int id){
        return restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+ id +"?api_key=" + apiKey, Movie.class);
    }
}
