package ru.job4j.poly;

public class Bus extends Vehicle {
    private int passengers;
    private double fuel;

    @Override
    public void drive() {
        System.out.println("Автобус едет по дороге");
    }

    @Override
    public void passengers(int qty) {
        this.passengers = qty;
    }

    @Override
    public double refuel(double qty) {
        double price = Math.random() * 10 + 55;
        this.fuel = qty;
        return qty * price;
    }
}
