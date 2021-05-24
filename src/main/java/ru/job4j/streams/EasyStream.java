package ru.job4j.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> streamData;

    private EasyStream(List<Integer> source) {
        this.streamData = new ArrayList<>(source);
    }

    public static EasyStream of(List<Integer> source) {
        try {
            return new EasyStream(source);
        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        try {
            for (Integer number: streamData) {
                rsl.add(fun.apply(number));
            }
            return new EasyStream(rsl);
        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        try {
            for (Integer number: streamData) {
                if(fun.test(number)) {
                    rsl.add(number);
                }
            }
            return new EasyStream(rsl);
        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    public List<Integer> collect() {
        try {
            return new ArrayList<>(this.streamData);
        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }
}
