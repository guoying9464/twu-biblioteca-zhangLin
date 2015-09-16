package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.LibraryElement.Book;
import com.twu.biblioteca.LibraryElement.BookList;
import com.twu.biblioteca.Printer;

import java.util.Optional;

public class Return implements Operation {
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
        }
    }

    @Override
    public String toString() {
        return "Return Book";
    }
}
