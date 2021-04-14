package ru.job4j.poly;

public class Driving {
    public static void main(String[] args) {
        Bus anybus = new Bus();
        Train anytrain = new Train();
        Airplane anyplane = new Airplane();
        Vehicle[] list = new Vehicle[3];

        list[0] = anybus;
        list[1] = anytrain;
        list[2] = anyplane;
        for (Vehicle el: list) {
            el.drive();
        }
    }
}
