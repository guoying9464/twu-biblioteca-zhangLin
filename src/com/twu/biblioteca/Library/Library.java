package com.twu.biblioteca.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library<T extends Item > {
    private List<T> stockList;
    private List<T> checkoutList;
    private String name;

    public Library(List<T> stockList, String name) {
        this.stockList = stockList;
        this.name = name;
        this.checkoutList = new ArrayList<>();
    }

    public Optional find(String name, List<T> list) {
        return list.stream().filter(book -> name.equals(book.getName())).findFirst();
    }

    public boolean canReturn(String name) {
        return find(name, checkoutList).isPresent();
    }

    public boolean canCheckout(String name) {
        return find(name, stockList).isPresent();
    }

    public List<T> getStockList() {
        return stockList;
    }

    public List<T> getCheckoutList() {
        return checkoutList;
    }

    public String getName() {
        return name;
    }
}
