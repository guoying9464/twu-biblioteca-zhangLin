package com.twu.biblioteca;

import java.util.List;

public class Printer {
    public void print(String message){
        System.out.println(message);
    }

    public void print(List<Book> books){
        books.stream().forEach(book -> print(book.toString()));
    }

}
