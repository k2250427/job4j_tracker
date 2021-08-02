package ru.job4j.tracker;

import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Find item by id ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = memTracker.findById(id);
        if (Objects.nonNull(item)) {
            out.println(item);
        } else {
            out.println("Заявка не найдена");
        }
        return true;
    }
}
