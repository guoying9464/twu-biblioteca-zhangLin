package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.Printer;

import java.util.List;

public class SearchCatalog implements Operation{

    private List<Book> books;
    private Printer printer;

    public SearchCatalog(List<Book> books, Printer printer) {
        this.books = books;
        this.printer = printer;
    }

    @Override
    public void operate() {
        printer.print(books);
    }

    @Override
    public String toString() {
        return "SearchCatalog";
    }
}
