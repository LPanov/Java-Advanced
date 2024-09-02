package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String command = sc.nextLine();
        while(!command.equals("search")) {
            String[] token = command.split("-");
            String name = token[0];
            String number = token[1];

            phonebook.put(name, number);
            command = sc.nextLine();
        }
        String searchedName = sc.nextLine();
        while (!searchedName.equals("stop")) {
            if (phonebook.containsKey(searchedName)) {
                System.out.println(searchedName + " -> " + phonebook.get(searchedName));
            } else {
                System.out.println("Contact "+searchedName+" does not exist.");
            }

            searchedName = sc.nextLine();
        }
    }
}
