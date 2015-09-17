package com.twu.biblioteca.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> bookList;
    private List<Book> checkoutList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
        this.checkoutList = new ArrayList<>();
    }

    public Optional<Book> findBook(String name, List<Book> books) {
        return books.stream().filter(book -> name.equals(book.getName())).findFirst();
    }

    public boolean canReturn(String name) {
        return findBook(name, checkoutList).isPresent();
    }

    public boolean canCheckout(String name) {
        return findBook(name, bookList).isPresent();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getCheckoutList() {
        return checkoutList;
    }
}
