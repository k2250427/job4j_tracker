package ru.job4j.oop;

public class Builder extends Engineer {
    private boolean admission;

    public Builder(String name, String surname, String edu, String birthday) {
        super(name, surname, edu, birthday);
    }

    public boolean getAdmission() {
        return this.admission;
    }
}
