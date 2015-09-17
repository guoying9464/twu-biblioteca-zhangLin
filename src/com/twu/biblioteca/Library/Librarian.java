package com.twu.biblioteca.library;

public class Librarian {
    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public int checkoutBook(String name) {
        if(library.canCheckout(name)){
            Book book = library.findBook(name, library.getBookList()).get();
            library.getBookList().remove(book);
            library.getCheckoutList().add(book);
            return 1;
        }
        return 0;
    }

    public int returnBook(String bookName) {
        if(library.canReturn(bookName)){
            Book book = library.findBook(bookName, library.getCheckoutList()).get();
            library.getCheckoutList().remove(book);
            library.getBookList().add(book);
            return 1;
        }
        return 0;
    }

    public Library getLibrary() {
        return library;
    }
}
