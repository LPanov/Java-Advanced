package IteratorsAndComparators.Exercises.EqualityLogic;

import java.util.Comparator;

public class CompareNameAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int compare = o1.getName().compareTo(o2.getName());
        if (compare == 0) {
            compare = Integer.compare(o1.getAge(), o2.getAge());
        }
        return compare;
    }
}

