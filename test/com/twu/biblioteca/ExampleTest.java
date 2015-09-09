package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleTest {
    private ByteArrayOutputStream output;

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp.WelcomeMessagePrinter();
        assertThat(output.toString(), is("Welcome to Bibliteca!\n"));
    }

    @Test
    public void testBookList() throws Exception {
        String expect = "BookList:\n" +
                "The Adventures of Sherlock Holmes\n" +
                "Grimm's Fairy Tales\n" +
                "Wuthering Heights\n" +
                "Moon and Sixpence\n";
        BibliotecaApp.BookList();
        assertThat(output.toString(), is(expect));
    }
}
