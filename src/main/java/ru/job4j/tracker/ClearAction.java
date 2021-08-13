package ru.job4j.tracker;

public class ClearAction implements UserAction {
    private final Output out;

    public ClearAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete all Items ====");
        memTracker.deleteAll();
        return true;
    }
}
