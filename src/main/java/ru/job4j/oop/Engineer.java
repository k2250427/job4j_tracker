package ru.job4j.oop;

public class Engineer extends Profession{
    private String specialization;

    public Engineer() {
        super();
        this.specialization = "";
    }

    public String getSpecialization() {
        return this.specialization;
    }
}
