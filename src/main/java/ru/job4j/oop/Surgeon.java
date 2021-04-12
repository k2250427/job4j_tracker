package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String profField;

    public Surgeon(String name, String surname, String edu, String birthday) {
        super(name, surname, edu, birthday);
    }

    public String getProfField() {
        return this.profField;
    }
}
