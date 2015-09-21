package com.twu.biblioteca.library;

public class Book implements Item{
    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    private String name;
    private String author;
    private String year;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", name, author, year);
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }
}
