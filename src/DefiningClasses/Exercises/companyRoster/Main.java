package DefiningClasses.Exercises.companyRoster;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Employee>> departments = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email;
            int age;
            Employee employee;
            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            else if (input.length == 5) {
                if (Character.isDigit(input[4].charAt(0))) {
                    age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            else employee = new Employee(name, salary, position, department);

            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }

        String bestDepartment = getHighest(departments);
        System.out.println("Highest Average Salary: " + bestDepartment);
        departments.get(bestDepartment)
                .stream().sorted((x, y) -> (int) (y.getSalary() - x.getSalary()))
                .forEach(employee -> System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));


    }

    public static String getHighest(Map<String, List<Employee>> departments) {
        AtomicReference<Double> avgSalary = new AtomicReference<>(Double.MIN_NORMAL);
        AtomicReference<String> name = new AtomicReference<>("");
        departments.entrySet().stream().forEach(entry -> {
            double totalSalary = 0;
            int total = 0;
            for (Employee salary : entry.getValue()) {
                totalSalary += salary.getSalary();
            }

            double avg = totalSalary/entry.getValue().size();
            if (avg > avgSalary.get()) {
                avgSalary.set(avg);
                name.set(entry.getKey());
            }
        });

        return name.get();
    }
}
