package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.Printer;
import com.twu.biblioteca.library.Librarian;

public class Return implements Operation {
    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the %s.";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid %s to return.";
    private Printer printer;
    private Inputer inputer;
    private Librarian librarian;

    public Return(Printer printer, Inputer inputer, Librarian librarian) {
        this.printer = printer;
        this.inputer = inputer;
        this.librarian = librarian;
    }

    @Override
    public void operate() {
        String successMsg = String.format(SUCCESSFUL_RETURN_MESSAGE, getElementName());
        String unsuccessMsg = String.format(UNSUCCESSFUL_RETURN_MESSAGE, getElementName());

        printer.print(String.format("Please Input The %s Name:", getElementName()));
        String bookName = inputer.input();
        int result = librarian.returnBook(bookName);
        if (1 == result) {
            librarian.returnBook(bookName);
            printer.print(successMsg);
        }else{
            printer.print(unsuccessMsg);
        }
    }

    private String getElementName() {
        return librarian.getLibrary().getName();
    }

    @Override
    public String toString() {
        return String.format("%s %s", "Return", getElementName());

    }
}
