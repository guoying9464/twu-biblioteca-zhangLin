package com.twu.biblioteca;

import com.twu.biblioteca.library.*;
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
        Library bookLibrary = new Library(books, "Book");

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Gone  Girl", "2014", "David Fincher", 8));
        movies.add(new Movie("Black Mass", "2015", "Scott  Cooper", 7));
        movies.add(new Movie("Katti Batti", "2015", "Nikhil Advani", 6));
        Library movieLibrary = new Library(movies, "Movie");

        Librarian bookLibrarian = new Librarian(bookLibrary);
        Librarian movieLibrarian = new Librarian(movieLibrary);
        Printer printer = new Printer();
        Inputer inputer = new Inputer();

        Map<Integer, Operation> menuItem = new HashMap<>();
        menuItem.put(1, new SearchCatalog(books, printer));
        menuItem.put(2, new SearchCatalog(movies, printer));
        menuItem.put(3, new CheckOut(printer, inputer, bookLibrarian));
        menuItem.put(4, new Return(printer, inputer, bookLibrarian));
        menuItem.put(5, new CheckOut(printer, inputer, movieLibrarian));
        menuItem.put(6, new Return(printer, inputer, movieLibrarian));
        menuItem.put(7, new Quit());
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
