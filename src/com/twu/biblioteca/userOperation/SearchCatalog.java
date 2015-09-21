package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Printer;
import com.twu.biblioteca.library.Book;

import java.util.List;

public class SearchCatalog<T> implements Operation{

    private List<T> list;
    private Printer printer;

    public SearchCatalog(List<T> list, Printer printer) {
        this.list = list;
        this.printer = printer;
    }

    @Override
    public void operate() {
        printer.print(list);
    }

    @Override
    public String toString() {
        return  (list.get(0).getClass().equals(Book.class)) ?
                "Book SearchCatalog" : "Movie SearchCatalog";
    }
}
