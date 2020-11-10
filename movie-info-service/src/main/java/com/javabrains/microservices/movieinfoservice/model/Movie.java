package com.javabrains.microservices.movieinfoservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Aleksandar on Jan, 2020
 */

@Setter
@Getter
public class Movie {
    private int id;
    private String title;
    private String overview;

    public Movie() {
    }

    public Movie(int id, String name, String overview) {
        this.id = id;
        this.title = name;
        this.overview = overview;
    }
}
