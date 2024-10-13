package ExamPreparation.Retake12August2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WildSurvival {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> bees = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> beeEaters = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            int beesFighters = bees.getFirst();
            int beeEatersFighters = beeEaters.getLast();

            while (true) {
                if (beesFighters < 7) {
                    bees.removeFirst();
                    beeEaters.removeLast();
                    beeEaters.addLast(beeEatersFighters);
                    break;
                }
                if (beeEatersFighters == 0) {
                    beeEaters.removeLast();
                    bees.removeFirst();
                    bees.addLast(beesFighters);
                    break;
                }

                beesFighters -= 7;
                beeEatersFighters--;
            }

            if (bees.isEmpty()) break;
            if (beeEaters.isEmpty()) break;

        }


        if (bees.contains(0)) {
            bees.remove((Integer) 0);
        }
        if (beeEaters.contains(0)) {
            beeEaters.remove((Integer) 0);
        }

        List<String> beesStr = bees.stream().map(Object::toString).collect(Collectors.toList());
        List<String> beeEatersStr = beeEaters.stream().map(Object::toString).collect(Collectors.toList());

        System.out.println("The final battle is over!");
        if (bees.isEmpty() && beeEaters.isEmpty()){
            System.out.println("But no one made it out alive!");
        }
        else if (bees.isEmpty() && !beeEaters.isEmpty() ) {
            System.out.println("Bee-eater groups left: " + String.join(", ", beeEatersStr));
        }
        else if (!bees.isEmpty() && beeEaters.isEmpty()){
            System.out.println("Bee groups left: " + String.join(", ", beesStr));
        }

    }



}
