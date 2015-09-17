package com.twu.biblioteca.library;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LibrarianTest {
    private List<Book> books = new ArrayList<>();
    private Librarian librarian;

    @Before
    public void setUp() throws Exception {
        books.add(new Book("Grimm's Fairy Tales", "Jacob Grimm", "2011"));
        books.add(new Book("Wuthering Heights", "Emily Bronte", "2011"));
        books.add(new Book("Moon and Sixpence", "W. Somerset", "2012"));
        librarian = new Librarian(books);
    }

    @Test
    public void testShouldGetBookFromName() throws Exception {
        Optional<Book> book = librarian.getBorrowableBook("Grimm's Fairy Tales");
        assertTrue(book.isPresent());
        assertThat(book.get().getAuthor(), is("Jacob Grimm"));
    }

    @Test
    public void testShouldNotGetBookForIncorrectName() throws Exception {
        Optional<Book> book = librarian.getBorrowableBook("ABC");
        assertFalse(book.isPresent());
    }

    @Test
    public void testCheckOut() throws Exception {
        Optional<Book> book = librarian.getBorrowableBook("Grimm's Fairy Tales");
        librarian.checkoutBook(book.get());
        book = librarian.getBorrowableBook("Grimm's Fairy Tales");
        assertFalse(book.isPresent());
    }
}