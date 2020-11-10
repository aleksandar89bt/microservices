package com.javabrains.microservices.movieratingservice.controller;

import com.javabrains.microservices.movieratingservice.model.Rating;
import com.javabrains.microservices.movieratingservice.model.RatingListWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksandar on Jan, 2020
 */

@RestController
@RequestMapping("ratings")
public class RatingController {

    @GetMapping("{movieId}")
    public Rating getRating(@PathVariable int movieId) {
        return new Rating(movieId, 5);
    }

    @GetMapping("user/{userId}")
    public RatingListWrapper getUsersRatings(@PathVariable int userId) {

        return new RatingListWrapper(Arrays.asList(
                new Rating(550, 5),
                new Rating(551, 4),
                new Rating(552, 5)
        ));
    }
}
