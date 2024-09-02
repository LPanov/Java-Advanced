package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "(?<name>.+)@(?<platform>.+)\\.(?<domain>\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, String> people = new LinkedHashMap<>();

        while (true) {
            String name = sc.nextLine();
            if (name.equals("stop")) break;
            String email = sc.nextLine();
            Matcher matcher = pattern.matcher(email);
            String domain = "";
            while (matcher.find()) {
                domain = matcher.group("domain");
            }
            if (!domain.equals("com") && !domain.equals("uk") && !domain.equals("us")) {
                people.put(name, email);
            }
        }

        people.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
