package SetsAndMapsAdvanced.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        String regex = "IP=(?<IP>.+)\\smessage='(?<message>.*)'\\suser=(?<user>.+)";
        Pattern pattern = Pattern.compile(regex);

        String command = sc.nextLine();
        while (!command.equals("end")) {
            Matcher matcher = pattern.matcher(command);
            String user = "";
            String IP = "";
            String message = "";
            while (matcher.find()) {
                user = matcher.group("user");
                IP = matcher.group("IP");
            }

            if (!users.containsKey(user)) {
                users.put(user, new LinkedHashMap<>());
                users.get(user).put(IP, 1);
            } else {
                if (!users.get(user).containsKey(IP)) {
                    users.get(user).put(IP, 1);
                } else {
                    users.get(user).put(IP, users.get(user).get(IP) + 1);
                }
            }
            command = sc.nextLine();
        }

        users.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            List<String> ipAddresses = new ArrayList<>();
            entry.getValue().entrySet().forEach(e -> {
                String str = e.getKey() + " => " + e.getValue();
                ipAddresses.add(str);
            });
            System.out.print(String.join(", ", ipAddresses));
            System.out.println(".");
        });
    }
}
