package ru.job4j.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public List<Integer> flatMatrix(Integer[][] arr) {
        return Arrays.stream(arr).flatMap(Stream::of).collect(Collectors.toList());
    }
}
