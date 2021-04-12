package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int newSize = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null && i < this.size - 1) {
                int ct = i + 1;
                while (ct < items.length && items[ct] == null) {
                    ct++;
                }
                if (ct < this.size) {
                    items[i] = items[ct];
                    items[ct] = null;
                    newSize = i + 1;
                }
            }
        }
        size = newSize;
        return Arrays.copyOf(items, newSize);
    }

    public Item[] findByName(String key) {
        if (key == null) {
            return new Item[0];
        }
        Item[] temp = new Item[this.size];
        int newSize = 0;
        for (Item n: items) {
            if (n != null && key.equals(n.getName())) {
                temp[newSize] = n;
                newSize++;
            }
        }
        return Arrays.copyOf(temp, newSize);
    }

    public void setNull(int index) {
        this.items[index] = null;
    }

    public void printItems() {
        for (int i = 0; i < this.size; i++) {
            if (this.items[i] != null) {
                System.out.println(this.items[i].getName());
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        Tracker trac = new Tracker();
        Item it = new Item("test");
        //Item[] temp;
        trac.add(it);
        it = new Item("test");
        trac.add(it);
        it = new Item("test");
        trac.add(it);
        Item it2 = new Item("test_2");
        trac.add(it2);
        it = new Item("test");
        trac.add(it);
        it = new Item("test");
        trac.add(it);
        it = trac.findById(4);
        if (it != null) {
            System.out.println(it.getName());
        } else {
            System.out.println("null");
        }

//        trac.setNull(2);
//        trac.setNull(4);
//
//        trac.printItems();
//        temp = trac.findByName("test");
//        System.out.println("-----------------------------------");
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i] != null) {
//                System.out.println(temp[i].getName());
//            } else {
//                System.out.println("null");
//            }
//        }
    }
}