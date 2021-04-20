package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len = Math.min(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            int rsl = Character.compare(leftChar, rightChar);
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
