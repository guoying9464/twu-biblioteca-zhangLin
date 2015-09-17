package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.Printer;

import java.util.Optional;

public class Return implements Operation {
    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.";
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
        printer.print("Please Input Book's Name:");
        Optional<Book> returnBook = librarian.getReturnableBook(inputer.input());
        if (returnBook.isPresent()) {
            librarian.returnBook(returnBook.get());
            printer.print(SUCCESSFUL_RETURN_MESSAGE);
        }else{
            printer.print(UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Return Book";
    }
}
