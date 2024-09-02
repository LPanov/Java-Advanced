package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String IP = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            if (!users.containsKey(user)) {
                users.put(user, new HashMap<>());
                users.get(user).put(IP, duration);
            } else {
                if (!users.get(user).containsKey(IP)) {
                    users.get(user).put(IP, duration);
                } else {
                    users.get(user).put(IP, users.get(user).get(IP) + duration);
                }
            }
        }

        users.entrySet().stream().forEach(entry -> {
            int sum = entry.getValue().values().stream().mapToInt(d -> d).sum();
            List<String> ips = new ArrayList<>();
            entry.getValue().entrySet().stream().forEach(e -> ips.add(e.getKey()));
            Collections.sort(ips);

            System.out.print(entry.getKey() + ": " + sum + " [");
            System.out.print(String.join(", ", ips));
            System.out.println("]");


        });
    }
}
