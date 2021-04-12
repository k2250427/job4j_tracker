package ru.job4j.oop;

public class Programmer extends Engineer {
    private String[] languages;

    public Programmer(String name, String surname, String edu, String birthday) {
        super(name, surname, edu, birthday);
    }

    public void printLanguages() {
        for (String lng: languages) {
            System.out.println(lng);
        }
    }
}
