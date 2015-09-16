package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Printer;

import java.util.List;

public class BookList implements Operation{

    private List<Book> bookList;
    private Printer printer;

    public BookList(List<Book> bookList, Printer printer) {
        this.bookList = bookList;
        this.printer = printer;
    }

    @Override
    public void operate() {
        printer.print(bookList);
    }

    @Override
    public String toString() {
        return "BookList";
    }
}
