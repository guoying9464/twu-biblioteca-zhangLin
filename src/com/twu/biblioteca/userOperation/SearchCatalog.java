package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.LibraryElement.BookList;
import com.twu.biblioteca.Printer;

public class SearchCatalog implements Operation{

    private BookList bookList;
    private Printer printer;

    public SearchCatalog(BookList bookList, Printer printer) {
        this.bookList = bookList;
        this.printer = printer;
    }

    @Override
    public void operate() {
        printer.print(bookList.getBookList());
    }

    @Override
    public String toString() {
        return "SearchCatalog";
    }
}
