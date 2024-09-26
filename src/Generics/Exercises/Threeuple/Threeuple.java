package Generics.Exercises.Threeuple;

public class Threeuple <T1, T2, T3> extends Tuple {
    private T3 item3;

    @SuppressWarnings("unchecked")
    public Threeuple(Object item1, Object item2, T3 item3) {
        super(item1, item2);
        this.item3 = item3;
    }

    public T3 getItem3() {
        return item3;
    }

    public void setItem3(T3 item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return getItem1() + " -> " +
                getItem2() + " -> " +
                this.item3;
    }
}
