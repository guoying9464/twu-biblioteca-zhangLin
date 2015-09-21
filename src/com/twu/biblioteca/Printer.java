package com.twu.biblioteca;

import com.twu.biblioteca.library.Menu;

import java.util.List;

public class Printer {
    public void print(String message){
        System.out.println(message);
    }

    public void print(List list){
        list.stream().forEach(object -> print(object.toString()));
    }

    public void print(Menu menu) {
        print(menu.toString());
    }
}
