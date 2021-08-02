package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Show all items ====");
        List<Item> items = memTracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item.toString());
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
