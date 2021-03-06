package com.twu.biblioteca.library;

import com.twu.biblioteca.userOperation.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<Integer, Operation> menu;

    public Menu(Map<Integer, Operation> menu) {
        this.menu = menu;
    }

    public boolean isVaild(int option) {
        return menu.containsKey(option);
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList();
        menu.entrySet().stream().forEach(entry ->
                result.add(String.format("%d\t%s",
                        entry.getKey(), entry.getValue().toString())));
        return String.join("\n", result);
    }
}
