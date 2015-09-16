package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.LibraryElement.Book;
import com.twu.biblioteca.LibraryElement.BookList;
import com.twu.biblioteca.Printer;

import java.util.Optional;

public class CheckOut implements Operation{
    public static final String SUCCESS_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    private static final String UNSUCCESS_CHECKOUT_MESSAGE = "That book is not available.";
    private Printer printer;
    private Inputer inputer;
    private BookList bookList;

    public CheckOut(Printer printer, Inputer inputer, BookList bookList) {
        this.printer = printer;
        this.inputer = inputer;
        this.bookList = bookList;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name:");
        printer.print(bookList.getBookList());
        Optional<Book> checkoutBook = bookList.getBorrowableBook(inputer.input());
        if(checkoutBook.isPresent()){
            bookList.checkoutBook(checkoutBook.get());
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
