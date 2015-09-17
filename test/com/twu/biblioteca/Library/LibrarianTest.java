package com.twu.biblioteca.library;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibrarianTest {
    private List<Book> books = new ArrayList<>();
    private Library library;
    private Librarian librarian;

    @Before
    public void setUp() throws Exception {
        books.add(new Book("Grimm's Fairy Tales", "Jacob Grimm", "2011"));
        books.add(new Book("Wuthering Heights", "Emily Bronte", "2011"));
        books.add(new Book("Moon and Sixpence", "W. Somerset", "2012"));
        library = new Library(books);
        librarian = new Librarian(library);
    }

    @Test
    public void testCanCheckoutBook() throws Exception {
        int result = librarian.checkoutBook("Grimm's Fairy Tales");
        assertThat(result, is(1));
    }

    @Test
    public void testCannotCheckoutBookForNonexistentBook() throws Exception {
        int result = librarian.checkoutBook("JAVA");
        assertThat(result, is(0));
    }

    @Test
    public void testCannotCheckoutBookForBorrowedBook() throws Exception {
        librarian.checkoutBook("Grimm's Fairy Tales");
        int result = librarian.checkoutBook("Grimm's Fairy Tales");
        assertThat(result, is(0));
    }

    @Test
    public void testCanReturnBook() throws Exception {
        librarian.checkoutBook("Grimm's Fairy Tales");
        int result = librarian.returnBook("Grimm's Fairy Tales");
        assertThat(result, is(1));
    }

    @Test
    public void testCannotReturnBookForNonexistentBook() throws Exception {
        int result = librarian.returnBook("JAVA");
        assertThat(result, is(0));
    }
}