package ru.job4j.collection;

import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftArray = left.toCharArray();
        Arrays.sort(leftArray);
        char[] rightArray = right.toCharArray();
        Arrays.sort(rightArray);
        return Arrays.equals(leftArray, rightArray);
    }
}