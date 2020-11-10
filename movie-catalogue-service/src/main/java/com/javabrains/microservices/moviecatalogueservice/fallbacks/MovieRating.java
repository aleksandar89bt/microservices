package com.javabrains.microservices.moviecatalogueservice.fallbacks;

import com.javabrains.microservices.moviecatalogueservice.model.Rating;
import com.javabrains.microservices.moviecatalogueservice.model.RatingListWrapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Aleksandar on Mar, 2020
 */
@Component
public class MovieRating {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackRatingList")
    public RatingListWrapper getRatingList(@PathVariable int userId) {
        return restTemplate.getForObject("http://movie-rating-service/ratings/user/" + userId, RatingListWrapper.class);
    }

    public RatingListWrapper getFallbackRatingList(@PathVariable int userId) {
        RatingListWrapper ratingListWrapper = new RatingListWrapper();
        ratingListWrapper.setRatings(Arrays.asList(new Rating()));
        return ratingListWrapper;
    }
}
