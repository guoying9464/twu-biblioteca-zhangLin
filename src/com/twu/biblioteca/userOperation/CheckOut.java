package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.library.Librarian;

public class CheckOut implements Operation{
    public static final String SUCCESS_CHECKOUT_MESSAGE = "Thank you! Enjoy the %s";
    private static final String UNSUCCESS_CHECKOUT_MESSAGE = "That %s is not available.";
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
        String successMsg = String.format(SUCCESS_CHECKOUT_MESSAGE, getElementName());
        String unsuccessMsg = String.format(UNSUCCESS_CHECKOUT_MESSAGE, getElementName());
        printer.print("Please Input It's Name:");
        printer.print(librarian.getLibrary().getStockList());
        int result = librarian.checkout(inputer.input());
        if(1 == result){
            printer.print(successMsg);
        }else {
            printer.print(unsuccessMsg);
        }
    }

    private String getElementName() {
        return librarian.getLibrary().getName();
    }

    @Override
    public String toString() {
        return String.format("%s %s", "Checkout", getElementName());
    }
}
