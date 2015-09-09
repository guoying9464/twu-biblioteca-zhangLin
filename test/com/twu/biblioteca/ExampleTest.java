package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleTest {
    private static final String WELCOME_MESSAGE = "Welcome to Bibliteca!\n";
    private ByteArrayOutputStream output;
    private BibliotecaApp.Printer printer;
    List<String> bookList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        printer = new BibliotecaApp.Printer();

    }

    @Test
    public void testMessagePrinter() {
        printer.print(WELCOME_MESSAGE);
        assertThat(output.toString(), is("Welcome to Bibliteca!\n"));
    }

    @Test
    public void testStringsPrinter() throws Exception {
        bookList.add("BookList:\n");
        bookList.add("Grimm's Fairy Tales\n");
        bookList.add("Wuthering Heights\n");
        bookList.add("Moon and Sixpence\n");

        String expect = "BookList:\n" +
                "Grimm's Fairy Tales\n" +
                "Wuthering Heights\n" +
                "Moon and Sixpence\n";
        printer.print(bookList);
        assertThat(output.toString(), is(expect));
    }

    @Test
    public void testMapPrinter() throws Exception {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Grimm's Fairy Tales\t",addBookInfo("Jacob Grimm\t", "2011\t\n"));
        map.put("Wuthering Heights\t",addBookInfo("Emily Bronte\t", "2011\t\n"));
        map.put("Moon and Sixpence\t", addBookInfo("W. Somerset\t", "2012\t\n"));

        String expect = "Wuthering Heights\tEmily Bronte\t2011\t\n" +
                "Moon and Sixpence\tW. Somerset\t2012\t\n" +
                "Grimm's Fairy Tales\tJacob Grimm\t2011\t\n";

        printer.print(map);
        assertThat(output.toString(), is(expect));
    }

    private List addBookInfo(String author, String year){
        List list =  new ArrayList<String>();
        list.add(author);
        list.add(year);
        return list;
    }
}
