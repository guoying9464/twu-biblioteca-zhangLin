package com.twu.biblioteca;

import java.util.Scanner;

public class Inputer {
    private Scanner scanner;

    public Inputer() {
        this.scanner = new Scanner(System.in);
    }

    public String input(){
        return scanner.nextLine();
    }
}
