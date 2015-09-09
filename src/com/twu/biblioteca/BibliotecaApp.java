package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";

    public static void main(String[] args) {
        List<String> bookList = new ArrayList<>();
        bookList.add("BookList:");
        bookList.add("The Adventures of Sherlock Holmes");
        bookList.add("Grimm's Fairy Tales");
        bookList.add("Wuthering Heights");
        bookList.add("Moon and Sixpence");

        Printer printer = new Printer();
        printer.print(WELCOME_MESSAGE);
        printer.print(bookList);
    }

    public static class Printer{
        public void print(String message){
            System.out.println(message);
        }

        public void print(List<String> strings){
            strings.stream().forEach(book -> System.out.println(book));
        }
    }

}
