package IteratorsAndComparators.Exercises.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake{
    List<Integer> lakeNumbers;
    Frog frog;

    public Lake() {
        this.lakeNumbers = new ArrayList<>();
        this.frog = new Frog();
    }

    public void addAll(List<Integer> integers) {
        lakeNumbers.addAll(integers);
    }

    public List<Integer> getLakeNumbers() {
        return lakeNumbers;
    }

    public Frog getFrog() {
        return frog;
    }

    public class Frog implements Iterator<Integer>{
        List<Integer> jumpedNumbers;
        private int counter;

        public Frog() {
            this.jumpedNumbers = new ArrayList<>();
            this.counter = 0;
        }

        public List<Integer> getJumpedNumbers() {
            return jumpedNumbers;
        }

        public void add(int element) {
            this.jumpedNumbers.add(element);
        }

        @Override
        public boolean hasNext() {
            int i = this.counter + 1;
            return i < this.jumpedNumbers.size();
        }

        @Override
        public Integer next() {
            return this.jumpedNumbers.get(counter++);
        }
    }

    public void jumpOver() {
        for (int i = 0; i < this.lakeNumbers.size(); i+=2) {
            this.frog.add(lakeNumbers.get(i));
        }

        for (int i = 1; i < this.lakeNumbers.size(); i+=2) {
            this.frog.add(lakeNumbers.get(i));
        }


    }
}
