package ru.job4j.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsageToMap {
    public Map<String, Student> ListToMap(List<Student> students){
        return students.stream().distinct().collect(
                Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student
                )
        );
    }
}
