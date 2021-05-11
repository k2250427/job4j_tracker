package ru.job4j.function;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class RangeCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = RangeCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = RangeCalc.diapason(5, 8, x ->  x * x - 3);
        List<Double> expected = Arrays.asList(22D, 33D, 46D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = RangeCalc.diapason(5, 8, x -> 2 * Math.exp(x) + 5);
        List<Double> expected = Arrays.asList(301.8263182051532, 811.8575869854702, 2198.266316856917);
        assertThat(result, is(expected));
    }
}