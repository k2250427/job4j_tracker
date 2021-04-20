package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int posLeft = left.indexOf(". ");
        int posRight = right.indexOf(". ");
        if (posLeft <= 0 || posRight <= 0) {
            return left.compareTo(right);
        }
        String leftNum = left.substring(0, posLeft - 1);
        String rightNum = right.substring(0, posRight - 1);
        return leftNum.compareTo(rightNum);
    }
}
