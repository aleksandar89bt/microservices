package com.javabrains.microservices.moviecatalogueservice.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Aleksandar on Jan, 2020
 */

@Setter
@Getter
public class MovieCatalogue {

    private int id;
    private String name;
    private String description;
    private int rating;

    public MovieCatalogue() {
    }

    public MovieCatalogue(String name, String description, int rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public MovieCatalogue(int id, String name, String description, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieCatalogue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
