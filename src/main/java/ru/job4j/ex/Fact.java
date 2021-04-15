package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        int rsl = calc(-1);
    }

    public static int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Аргумент задан отрицательным числом");
        }

        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
