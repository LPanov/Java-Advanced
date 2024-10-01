package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int compare = Integer.compare(o1.getName().length(), o2.getName().length());
        if (compare == 0) {
            char let1 = o1.getName().toLowerCase().charAt(0);
            char let2 = o2.getName().toLowerCase().charAt(0);
            compare = Character.compare(let1, let2);
        }
        return compare;
    }
}
