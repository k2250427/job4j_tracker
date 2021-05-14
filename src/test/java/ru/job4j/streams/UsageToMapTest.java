package ru.job4j.streams;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UsageToMapTest {

    @Test
    public void listToMap() {
        List<Student> students = List.of(
                new Student(10, "Ivanov"),
                new Student(5, "Petrov"),
                new Student(12, "Ivanov"),
                new Student(15, "Sidorov")
        );
        UsageToMap um = new UsageToMap();
        HashMap<String, Student> rsl = (HashMap<String, Student>) um.ListToMap(students);
        HashMap<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student(10, "Ivanov"));
        expected.put("Petrov", new Student(5, "Petrov"));
        expected.put("Sidorov", new Student(15, "Sidorov"));
        assertThat(rsl, is(expected));
    }
}