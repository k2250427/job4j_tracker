package ru.job4j.oop;

public class Programmer extends Engineer {
    private String[] languages;

    public void printLanguages() {
        for (String lng: languages) {
            System.out.println(lng);
        }
    }
}