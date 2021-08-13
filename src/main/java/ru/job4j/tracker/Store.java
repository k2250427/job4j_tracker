package ru.job4j.tracker;

import java.util.List;

public interface Store extends AutoCloseable {
    void init();
    Item add(Item item);
    int getSize();
    boolean replace(int id, Item item);
    boolean delete(int id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(int id);
    boolean deleteAll();
}