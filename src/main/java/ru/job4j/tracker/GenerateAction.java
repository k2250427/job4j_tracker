package ru.job4j.tracker;

public class GenerateAction implements UserAction {
    private final Output out;

    public GenerateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add 100k new Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Create a 100k new Items ====");
        for (int i = 0; i < 100000; i++) {
            Item item = new Item("Item ".concat(Integer.toString(i)));
            memTracker.add(item);
        }
        return true;
    }
}