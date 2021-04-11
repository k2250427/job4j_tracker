package ru.job4j.oop;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

@Test
public class PointTest {

    public void testDistance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(4, 0, 0);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(4, 0.001));
    }
}