package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Grimm's Fairy Tales", "Jacob Grimm", "2011"));
        bookList.add(new Book("Wuthering Heights", "Emily Bronte", "2011"));
        bookList.add(new Book("Moon and Sixpence", "W. Somerset", "2012"));

        Map<Integer, String> menuItem = new HashMap<>();
        menuItem.put(1, "BookList");
        Menu menu = new Menu(menuItem);

        Printer printer = new Printer();
        printer.print(WELCOME_MESSAGE);
        printer.print(menu);

        Inputer inputer = new Inputer();
        if(inputer.option() == 1){
            printer.print(bookList);
        }
    }

}
