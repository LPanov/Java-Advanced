package SetsAndMapsAdvanced.Lab;

import java.util.*;


public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().split("\\s+");
            String name = token[0];
            Double grade = Double.parseDouble(token[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }

        students.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey() + " -> ");
            e.getValue().forEach(v -> System.out.printf("%.2f ", v));
            double sum = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                sum += e.getValue().get(i);
            }
            double avg = sum/e.getValue().size();
            System.out.printf("(avg: %.2f)%n", avg);
        });
    }
}
