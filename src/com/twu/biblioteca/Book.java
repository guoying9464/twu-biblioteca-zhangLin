package com.twu.biblioteca;

public class Book {
    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    private String name;
    private String author;
    private String year;

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", name, author, year);
    }
}
