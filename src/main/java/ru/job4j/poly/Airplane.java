package ru.job4j.poly;

public class Airplane extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Самолет летит по воздуху");
    }

    @Override
    public void passengers(int qty) {

    }

    @Override
    public double refuel(double qty) {
        return 0;
    }
}
