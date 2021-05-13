package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> leftMap = buildMap(left);
        HashMap<Character, Integer> rightMap = buildMap(right);
        for (Character ch: rightMap.keySet()) {
            if(leftMap.get(ch) == null || leftMap.get(ch) < rightMap.get(ch)) {
                return false;
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