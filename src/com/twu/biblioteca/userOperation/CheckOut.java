package com.twu.biblioteca.userOperation;

import com.twu.biblioteca.Inputer;
import com.twu.biblioteca.LibraryElement.Book;
import com.twu.biblioteca.LibraryElement.BookList;
import com.twu.biblioteca.Printer;

import java.util.Optional;

public class CheckOut implements Operation{
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
        Optional<Book> checkoutBook = bookList.getBook(inputer.input());
        if(checkoutBook.isPresent()){
            bookList.checkOut(checkoutBook.get());
            printer.print(bookList.getBookList());
        }
    }

    @Override
    public String toString() {
        return "CheckOut";
    }
}
