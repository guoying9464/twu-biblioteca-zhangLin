package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleTest {
    private static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";
    private ByteArrayOutputStream output;
    private BibliotecaApp.Printer printer;
    List<String> bookList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        printer = new BibliotecaApp.Printer();

        bookList.add("BookList:");
        bookList.add("The Adventures of Sherlock Holmes");
        bookList.add("Grimm's Fairy Tales");
        bookList.add("Wuthering Heights");
        bookList.add("Moon and Sixpence");
    }

    @Test
    public void testMessagePrinter() {
        printer.print(WELCOME_MESSAGE);
        assertThat(output.toString(), is("Welcome to Bibliteca!\n"));
    }

    @Test
    public void testStringsPrinter() throws Exception {
        String expect = "BookList:\n" +
                "The Adventures of Sherlock Holmes\n" +
                "Grimm's Fairy Tales\n" +
                "Wuthering Heights\n" +
                "Moon and Sixpence\n";
        printer.print(bookList);
        assertThat(output.toString(), is(expect));
    }
}
