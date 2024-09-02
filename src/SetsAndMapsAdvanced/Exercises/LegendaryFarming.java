package SetsAndMapsAdvanced.Exercises;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();

        while (true) {
            String[] s = sc.nextLine().toLowerCase().split("\\s+");
            boolean isReached = false;
            for (int i = 0; i < s.length; i++) {
                if (i % 2 == 0) {
                    if (materials.containsKey(s[i+1])) {
                        materials.put(s[i+1], materials.get(s[i+1]) + Integer.parseInt(s[i]));
                    } else {
                        materials.put(s[i+1], Integer.parseInt(s[i]));
                    }
                }
                if ((materials.containsKey("shards") && materials.get("shards") >= 250) ||
                        (materials.containsKey("fragments") && materials.get("fragments") >= 250) ||
                        (materials.containsKey("motes") && materials.get("motes") >= 250)  ) {
                    isReached = true;
                    break;
                }
            }
            if(isReached) break;

        }

        if (materials.containsKey("shards") && materials.get("shards") >= 250) {
            System.out.println("Shadowmourne obtained!");
            materials.put("shards", materials.get("shards") - 250);
        }
        else if (materials.containsKey("motes") && materials.get("motes") >= 250  ) {
            System.out.println("Dragonwrath obtained!");
            materials.put("motes", materials.get("motes") - 250);
        }
        else if (materials.containsKey("fragments") && materials.get("fragments") >= 250) {
            System.out.println("Valanyr obtained!");
            materials.put("fragments", materials.get("fragments") - 250);
        }

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("fragments", materials.get("fragments"));
        keyMaterials.put("shards", materials.get("shards"));
        keyMaterials.put("motes", materials.get("motes"));
        keyMaterials.entrySet().stream()
                .sorted((s1, s2) -> printNull(s2) - printNull(s1))
                .forEach(entry -> System.out.println(entry.getKey()+": " + printNull(entry)));

        materials.remove("shards");
        materials.remove("fragments");
        materials.remove("motes");

        if(!materials.isEmpty()) materials.entrySet().stream()
                .sorted(comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + printNull(entry)));

    }

    private static int printNull(Map.Entry<String, Integer> entry) {
        if (entry.getValue() == null) return 0;
        else return entry.getValue();
    }

}
