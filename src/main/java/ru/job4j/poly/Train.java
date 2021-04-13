package ru.job4j.poly;

public class Train extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Поезд едет по рельсам");
    }

    @Override
    public void passengers(int qty) {

    }

    @Override
    public double refuel(double qty) {
        return 0;
    }
}
