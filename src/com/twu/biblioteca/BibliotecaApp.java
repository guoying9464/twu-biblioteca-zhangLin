package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessagePrinter();
        BookList();
    }

    public static void WelcomeMessagePrinter() {
        System.out.println("Welcome to Bibliteca!");
    }

    public static void BookList(){
        List<String> bookList = new ArrayList<>();
        bookList.add("BookList:");
        bookList.add("The Adventures of Sherlock Holmes");
        bookList.add("Grimm's Fairy Tales");
        bookList.add("Wuthering Heights");
        bookList.add("Moon and Sixpence");
        bookList.stream().forEach(book -> System.out.println(book));
    }
}
