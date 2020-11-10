package com.javabrains.microservices.moviecatalogueservice.controller;

import com.javabrains.microservices.moviecatalogueservice.fallbacks.MovieCatalogueInfo;
import com.javabrains.microservices.moviecatalogueservice.fallbacks.MovieRating;
import com.javabrains.microservices.moviecatalogueservice.model.Movie;
import com.javabrains.microservices.moviecatalogueservice.model.MovieCatalogue;
import com.javabrains.microservices.moviecatalogueservice.model.Rating;
import com.javabrains.microservices.moviecatalogueservice.model.RatingListWrapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Aleksandar on Jan, 2020
 */

@RestController
@RequestMapping("movie-catalogue")
public class MovieCatalogueController {

    @Autowired
    private MovieCatalogueInfo movieCatalogueInfo;

    @Autowired
    private MovieRating movieRating;

    @GetMapping("{userId}")
    public List<MovieCatalogue> getMovieCatalogue(@PathVariable int userId) {
        RatingListWrapper wrapper = movieRating.getRatingList(userId);
        return wrapper.getRatings().stream()
                .map(rating -> movieCatalogueInfo.getMovieCatalogue(rating))
                .collect(Collectors.toList());
    }
}
