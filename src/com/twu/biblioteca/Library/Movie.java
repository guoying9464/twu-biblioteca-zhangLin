package com.twu.biblioteca.library;

public class Movie implements Item{
    private String name;
    private String year;
    private String director;
    private int rating;

    public Movie(String name, String year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t%s\t\t%s\t\t%d", name, director, year, rating);
    }
}
