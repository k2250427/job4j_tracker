package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortItemsDescendingTest {

    @Test
    public void compare() {
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        Item item4 = new Item("forth");

        List<Item> list = Arrays.asList(item1, item2, item3, item4);
        Item[] expected = new Item[] {item3, item2, item4, item1};
        Collections.sort(list, new SortItemsAscending());
        Item[] sortedList = list.toArray(new Item[4]);
        assertArrayEquals(expected, sortedList);
    }
}