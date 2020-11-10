package com.javabrains.microservices.moviecatalogueservice.model;

import java.util.List;

/**
 * Created by Aleksandar on Jan, 2020
 */
public class RatingListWrapper {
    private List<Rating> ratings;

    public RatingListWrapper() {
    }

    public RatingListWrapper(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
