package Generics.Lab.ListUtilities;

import java.util.List;
import java.util.Optional;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        checkEmpty(list);

        T min = list.getFirst();
        for (T l : list) {
            if (l.compareTo(min) < 0) min = l;
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        checkEmpty(list);

        T max = list.getFirst();
        for (T l : list) {
            if (l.compareTo(max) > 0) max = l;
        }
        return max;
    }

    public static <T> void checkEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list is passed!");
        }
    }
}
