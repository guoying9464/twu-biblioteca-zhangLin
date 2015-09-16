package com.twu.biblioteca;

import com.twu.biblioteca.userOperation.BookList;
import com.twu.biblioteca.userOperation.Operation;
import com.twu.biblioteca.userOperation.Quit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";
    public static final String VALID_OPTION_MESSAGE = "Select a valid option!";

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Grimm's Fairy Tales", "Jacob Grimm", "2011"));
        bookList.add(new Book("Wuthering Heights", "Emily Bronte", "2011"));
        bookList.add(new Book("Moon and Sixpence", "W. Somerset", "2012"));

        Printer printer = new Printer();
        Map<Integer, Operation> menuItem = new HashMap<>();
        menuItem.put(1, new BookList(bookList, printer));
        menuItem.put(2, new Quit());
        Menu menu = new Menu(menuItem);

        printer.print(WELCOME_MESSAGE);
        Inputer inputer = new Inputer();

        while (true){
            printer.print(menu);
            int option = getOption(inputer);
            if(menu.isVaild(option)){
                menuItem.get(option).operate();
            }else {
                printer.print(VALID_OPTION_MESSAGE);
            }
        }
    }

    private static int getOption(Inputer inputer) {
        try {
            return Integer.parseInt(inputer.option());

        } catch (Exception exception) {
            return -1;
        }
    }

}
