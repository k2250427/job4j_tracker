package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] subst1 = o1.split("/");
        String[] subst2 = o2.split("/");
        int size = Math.min(subst1.length, subst2.length);
        int rsl = subst2[0].compareTo(subst1[0]);
        if (rsl == 0) {
            for (int i = 1; i < size; i++) {
                rsl = subst1[i].compareTo(subst2[i]);
                if (rsl != 0) {
                    return rsl;
                }
            }
            if (subst1.length < subst2.length) {
                rsl = -1;
            } else if (subst1.length > subst2.length) {
                rsl = 1;
            } else {
                rsl = 0;
            }
        }
        return rsl;
    }
}