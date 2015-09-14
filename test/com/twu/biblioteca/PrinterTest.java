package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrinterTest {
    private static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";
    private ByteArrayOutputStream output;
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        printer = new Printer();

    }

    @Test
    public void testMessagePrinter() {
        printer.print(WELCOME_MESSAGE);
        assertThat(output.toString(), is("Welcome to Bibliteca!"));
    }

    @Test
    public void testBookPrinter() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Grimm's Fairy Tales", "Jacob Grimm", "2011"));
        bookList.add(new Book("Wuthering Heights", "Emily Bronte", "2011"));
        bookList.add(new Book("Moon and Sixpence", "W. Somerset", "2012"));

        String expect =
                "Grimm's Fairy Tales\tJacob Grimm\t2011\n" +
                        "Wuthering Heights\tEmily Bronte\t2011\n" +
                        "Moon and Sixpence\tW. Somerset\t2012\n";
        printer.print(bookList);
        assertThat(output.toString(), is(expect));
    }
}