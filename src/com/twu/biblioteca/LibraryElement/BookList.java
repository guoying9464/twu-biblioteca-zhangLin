package com.twu.biblioteca.LibraryElement;

import java.util.List;
import java.util.Optional;

public class BookList {
    List<Book> bookList;

    public BookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Optional<Book> getBook(String name) {
        return bookList.stream().filter(book -> name.equals(book.getName())).findFirst();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void checkOut(Book book) {
        bookList.remove(book);
    }
}
