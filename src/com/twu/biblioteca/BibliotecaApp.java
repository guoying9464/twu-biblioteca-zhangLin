package com.twu.biblioteca;

import com.twu.biblioteca.LibraryElement.Book;
import com.twu.biblioteca.LibraryElement.BookList;
import com.twu.biblioteca.LibraryElement.Menu;
import com.twu.biblioteca.userOperation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";
    public static final String VALID_OPTION_MESSAGE = "Select a valid option!";

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Grimm's Fairy Tales", "Jacob Grimm", "2011"));
        books.add(new Book("Wuthering Heights", "Emily Bronte", "2011"));
        books.add(new Book("Moon and Sixpence", "W. Somerset", "2012"));

        BookList bookList = new BookList(books);
        Printer printer = new Printer();
        Inputer inputer = new Inputer();

        Map<Integer, Operation> menuItem = new HashMap<>();
        menuItem.put(1, new SearchCatalog(bookList, printer));
        menuItem.put(2, new CheckOut(printer, inputer, bookList));
        menuItem.put(3, new Return(printer, inputer, bookList));
        menuItem.put(4, new Quit());
        Menu menu = new Menu(menuItem);

        printer.print(WELCOME_MESSAGE);

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
            return Integer.parseInt(inputer.input());

        } catch (Exception exception) {
            return -1;
        }
    }

}
