package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!\n";

    public static void main(String[] args) {
        List<String> bookList = new ArrayList<>();
        bookList.add("BookList:\n");
        bookList.add("Grimm's Fairy Tales\n");
        bookList.add("Wuthering Heights\n");
        bookList.add("Moon and Sixpence\n");

        Map<String, List<String>> map = new HashMap<>();
        map.put("Grimm's Fairy Tales\t", addBookInfo("Jacob Grimm\t", "2011\t\n"));
        map.put("Wuthering Heights\t", addBookInfo("Emily Bronte\t", "2011\t\n"));
        map.put("Moon and Sixpence\t", addBookInfo("W. Somerset\t", "2012\t\n"));

        Printer printer = new Printer();
        printer.print(WELCOME_MESSAGE);
        printer.print(bookList);
        printer.print(map);
    }

    private static List addBookInfo(String author, String year){
        List list =  new ArrayList<String>();
        list.add(author);
        list.add(year);
        return list;
    }

    public static class Printer{
        public void print(String message){
            System.out.print(message);
        }

        public void print(List<String> strings){
            strings.stream().forEach(book -> print(book));
        }

        public void print(Map<String, List<String>> map){
            map.entrySet().stream().forEach(entry -> {
                print(entry.getKey());
                print(entry.getValue());
            });
        }
    }

}
