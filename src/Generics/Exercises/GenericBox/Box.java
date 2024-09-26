package Generics.Exercises.GenericBox;

public class Box <T> {
    T input;

    public Box(T input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return ": " + input;
    }
}
