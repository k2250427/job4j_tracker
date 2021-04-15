package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = 0;
        for (String st: value) {
            if (st.equals(key)) {
                break;
            }
            rsl++;
        }
        if (rsl == value.length) {
            throw new ElementNotFoundException("Искомый элемент в массиве не найден");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] list = new String[] {"one", "two", "three", "four"};
        try {
            indexOf(list, "five");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
