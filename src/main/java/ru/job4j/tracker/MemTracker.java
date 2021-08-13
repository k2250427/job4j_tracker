package ru.job4j.tracker;

import java.util.Arrays;
import java.util.ArrayList;

public class MemTracker implements Store {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public void init() {

    }

    public void close() {

    }

    public int getSize() {
        return items.size();
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> temp = new ArrayList<>();
        for (Item item :items) {
            if (key.equals(item.getName())) {
                temp.add(item);
            }
        }
        return temp;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
    }

    public boolean deleteAll() {
        items.clear();
        return true;
    }
}