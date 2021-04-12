package ru.job4j.oop;

public class Dentist extends Doctor {
    private boolean isSurgeon;

    public Dentist(String name, String surname, String edu, String birthday) {
        super(name, surname, edu, birthday);
    }

    public boolean getIsSurgeon() {
        return this.isSurgeon;
    }
}
