package Generics.Exercises.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            String command = token[0];
            if (command.equals("Add")) {
                String element = token[1];
                customList.add(element);
            }
            else if (command.equals("Remove")) {
                int index = Integer.parseInt(token[1]);
                customList.remove(index);
            }
            else if (command.equals("Contains")) {
                String element = token[1];
                System.out.println(customList.contains(element));
            }
            else if (command.equals("Swap")) {
                int index1 = Integer.parseInt(token[1]);
                int index2 = Integer.parseInt(token[2]);
                customList.swap(index1, index2);
            }
            else if (command.equals("Greater")) {
                String element = token[1];
                System.out.println(customList.countGreater(element));
            }
            else if (command.equals("Max")) {
                System.out.println(customList.getMax());
            }
            else if (command.equals("Min")) {
                System.out.println(customList.getMin());
            }
            else if (command.equals("Print")) {
                customList.forEach(System.out::println);
            }

            input = scanner.nextLine();
        }

    }
}
