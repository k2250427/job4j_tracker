package ru.job4j.tracker;

public class SingleTracker {
    private static Tracker tracker = new Tracker();
    private static SingleTracker instance  = null;

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return instance.add(item);
    }

    public boolean replace(int id, Item item) {
        return instance.replace(id, item);
    }

    public boolean delete(int id) {
        return instance.delete(id);
    }

    public Item findById(int id) {
        return instance.findById(id);
    }

    public Item[] findAll() {
        return instance.findAll();
    }

    public Item[] findByName(String key) {
        return instance.findByName(key);
    }
}
