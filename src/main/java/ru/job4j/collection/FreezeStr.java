package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> leftMap = buildMap(left);
        char[] rightArray = right.toLowerCase().toCharArray();
        for (char ch: rightArray) {
            if(leftMap.get(ch) == null) {
                return false;
            } else if (leftMap.get(ch) == 1) {
                leftMap.remove(ch);
            } else {
                leftMap.replace(ch, leftMap.get(ch) - 1);
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> buildMap(String origin) {
        char[] originChars = origin.toLowerCase().toCharArray();
        HashMap<Character, Integer> rsl = new HashMap<>();
        for (char ch: originChars) {
            if(rsl.containsKey(ch)) {
                rsl.replace(ch, rsl.get(ch) + 1);
            } else {
                rsl.put(ch, 1);
            }
        }
        return rsl;
    }
}