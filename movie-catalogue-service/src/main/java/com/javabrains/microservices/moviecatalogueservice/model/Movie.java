package com.javabrains.microservices.moviecatalogueservice.model;

/**
 * Created by Aleksandar on Jan, 2020
 */

public class Movie {
    private int id;
    private String title;
    private String overview;

    public Movie() {
    }

    public Movie(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
