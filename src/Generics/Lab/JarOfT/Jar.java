package Generics.Lab.JarOfT;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    List<T> jar;

    public Jar() {
        this.jar = new ArrayList<>();
    }

    public void add(T element) {
        this.jar.addLast(element);
    }

    public T remove() {
        return this.jar.removeLast();
    }
}
