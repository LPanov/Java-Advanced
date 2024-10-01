package IteratorsAndComparators.Exercises.collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] create = scanner.nextLine().split(" ");
        String[] strings = new String[create.length-1];
        if (create.length != 1) {
            for (int i = 1; i < create.length; i++) {
                strings[i-1] = create[i];
            }
        }

        ListyIterator listyIterator = new ListyIterator(strings);
        String index = (strings.length > 0) ? listyIterator.getStrings()[0] : "";

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            if (command.equals("Move")) {
                if (listyIterator.hasNext()) {
                    System.out.println("true");
                    index = listyIterator.next();
                }
                else System.out.println("false");
            }
            else if (command.equals("Print")) {
                if (strings.length > 0) {
                    System.out.println(index);
                }
                else System.out.println("Invalid Operation!");

            }
            else if (command.equals("HasNext")) {
                System.out.println(listyIterator.hasNext());
            }
            else if (command.equals("PrintAll")) {
                listyIterator.forEach(f -> System.out.print(f + " "));
                System.out.println();
            }

            command = scanner.nextLine();
        }
    }
}
