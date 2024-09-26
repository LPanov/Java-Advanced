package Generics.Lab.GenericsArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int size, T defaultValue) {
        // Creating a generic array using reflection
        T[] array = (T[]) Array.newInstance(defaultValue.getClass(), size);
        Arrays.fill(array, defaultValue);
        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] array = (T[]) Array.newInstance(tClass, length);
        Arrays.fill(array, item);
        return array;
    }

}
