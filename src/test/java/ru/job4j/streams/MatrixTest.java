package ru.job4j.streams;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void whenArray2to4() {
        Integer[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        Matrix matrix = new Matrix();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> rsl = matrix.flatMatrix(arr);
        assertThat(rsl, is(expected));
    }
}