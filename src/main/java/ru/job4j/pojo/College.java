package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {

    public static void main(String[] args) {
        Student someone = new Student();
        someone.setName("Василий Теркин");
        someone.setGroup("Э-2-2021");
        someone.setAdmission(LocalDate.now());
        System.out.println(someone.getName());
        System.out.println(someone.getGroup());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String admisDate = someone.getAdmission().format(formatter);
        System.out.println(admisDate);
    }
}
