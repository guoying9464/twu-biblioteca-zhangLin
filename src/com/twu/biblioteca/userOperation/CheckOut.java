package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.library.Librarian;

public class CheckOut implements Operation{
    public static final String SUCCESS_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    private static final String UNSUCCESS_CHECKOUT_MESSAGE = "That book is not available.";
    private Printer printer;
    private Inputer inputer;
    private Librarian librarian;

    public CheckOut(Printer printer, Inputer inputer, Librarian librarian) {
        this.printer = printer;
        this.inputer = inputer;
        this.librarian = librarian;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name:");
        printer.print(librarian.getLibrary().getBookList());
        int result = librarian.checkoutBook(inputer.input());
        if(1 == result){
            printer.print(SUCCESS_CHECKOUT_MESSAGE);
        }else {
            printer.print(UNSUCCESS_CHECKOUT_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "CheckOut Book";
    }
}
