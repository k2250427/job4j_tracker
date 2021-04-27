package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] list = {"один", "два", "три", "четыре"};
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(list, cmpDescSize);
        for (String st : list) {
            System.out.println(st);
        }
    }
}
