package com.javabrains.microservices.movieratingservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Aleksandar on Jan, 2020
 */
@Getter
@Setter
public class Rating {

    private int movieId;
    private int rating;

    public Rating() {
    }

    public Rating(int movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}
