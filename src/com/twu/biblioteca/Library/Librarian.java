package com.twu.biblioteca.library;

public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public int checkout(String name) {
        if(library.canCheckout(name)){
            Object book = library.find(name, library.getStockList()).get();
            library.getStockList().remove(book);
            library.getCheckoutList().add(book);
            return 1;
        }
        return 0;
    }

    public int returnBook(String bookName) {
        if(library.canReturn(bookName)){
            Object book = library.find(bookName, library.getCheckoutList()).get();
            library.getCheckoutList().remove(book);
            library.getStockList().add(book);
            return 1;
        }
        return 0;
    }

    public Library getLibrary() {
        return library;
    }
}
