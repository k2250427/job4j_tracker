package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int len = Math.min(o1.length(), o2.length());
        for (int i = 0; i < len; i++) {
            int rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}