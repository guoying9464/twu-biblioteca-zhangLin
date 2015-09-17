package com.twu.biblioteca.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Librarian {
    List<Book> bookList;
    List<Book> checkoutList;

    public Librarian(List<Book> bookList) {
        this.bookList = bookList;
        this.checkoutList = new ArrayList<>();
    }

    public Optional<Book> getBorrowableBook(String name) {
        return bookList.stream().filter(book -> name.equals(book.getName())).findFirst();
    }

    public Optional<Book> getReturnableBook(String name) {
        return checkoutList.stream().filter(book -> name.equals(book.getName())).findFirst();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void checkoutBook(Book book) {
        bookList.remove(book);
        checkoutList.add(book);
    }

    public void returnBook(Book book) {
        checkoutList.remove(book);
        bookList.add(book);
    }
}
