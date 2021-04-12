package ru.job4j.oop;

public class Engineer extends Profession {
    private String specialization;

    public Engineer(String name, String surname, String edu, String birthday) {
        super(name, surname, edu, birthday);
        this.specialization = "";
    }

    public String getSpecialization() {
        return this.specialization;
    }
}
