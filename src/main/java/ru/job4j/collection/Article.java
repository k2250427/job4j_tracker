package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashMap;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashMap<String, Integer> originMap = buildMap(origin);
        HashMap<String, Integer> lineMap = buildMap(line);
        for (String word: lineMap.keySet()) {
            if(originMap.get(word) == null || originMap.get(word) < lineMap.get(word)) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<String, Integer> buildMap(String origin) {
        String[] originWords = origin.toLowerCase().split("\\W");
        HashMap<String, Integer> rsl = new HashMap<>();
        for (String word: originWords) {
            if(rsl.containsKey(word)) {
                rsl.replace(word, rsl.get(word) + 1);
            } else {
                rsl.put(word, 1);
            }
        }
        return rsl;
    }
}

