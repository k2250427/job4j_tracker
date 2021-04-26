package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] subst1 = o1.split("/");
        String[] subst2 = o2.split("/");
        int size = Math.min(subst1.length, subst2.length);
        int rsl = subst2[0].compareTo(subst1[0]);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}