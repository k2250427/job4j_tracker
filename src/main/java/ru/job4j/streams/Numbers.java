package ru.job4j.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, -2, 3, -4, 5);
        List<Integer> rsl = numbers.stream().filter(num -> num > 0).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
