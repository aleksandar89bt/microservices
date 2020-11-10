package com.javabrains.microservices.moviecatalogueservice.fallbacks;

import com.javabrains.microservices.moviecatalogueservice.model.Movie;
import com.javabrains.microservices.moviecatalogueservice.model.MovieCatalogue;
import com.javabrains.microservices.moviecatalogueservice.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Aleksandar on Mar, 2020
 */

@Component
public class MovieCatalogueInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovieCatalogue")
    public MovieCatalogue getMovieCatalogue(Rating rating) {
        Movie movie = restTemplate
                .getForObject("http://movie-info-service/movie-info/" + rating.getMovieId(), Movie.class);
        return new MovieCatalogue(movie.getId(), movie.getTitle(), movie.getOverview(), rating.getRating());
    }

    public MovieCatalogue getFallbackMovieCatalogue(Rating rating) {
        return new MovieCatalogue("No movie available", "", rating.getRating());
    }
}
