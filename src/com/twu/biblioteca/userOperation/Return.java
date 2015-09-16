package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.LibraryElement.Book;
import com.twu.biblioteca.LibraryElement.BookList;
import com.twu.biblioteca.Printer;

import java.util.Optional;

public class Return implements Operation {
    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.3";
    private Printer printer;
    private Inputer inputer;
    private BookList bookList;

    public Return(Printer printer, Inputer inputer, BookList bookList) {
        this.printer = printer;
        this.inputer = inputer;
        this.bookList = bookList;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name:");
        Optional<Book> returnBook = bookList.getReturnableBook(inputer.input());
        if (returnBook.isPresent()) {
            bookList.returnBook(returnBook.get());
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
