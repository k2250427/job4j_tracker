package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> emails = new HashMap<>();
        emails.put("parsentev@yandex.ru", "Petr Arsentev");
        emails.put("kstasyuk@yandex.ru", "Konstantin Stasyuk");
        for (String key : emails.keySet()) {
            System.out.println(key + " = " + emails.get(key));
        }
    }
}
