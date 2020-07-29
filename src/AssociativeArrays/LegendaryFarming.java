package AssociativeArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> items = new TreeMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();


        boolean isObtain = false;

        while (!isObtain) {
            String input = sc.nextLine();
            String[] splitInput = input.split(" ");
            for (int i = 0; i < splitInput.length; i += 2) {
                int count = Integer.parseInt(splitInput[i]);
                String element = splitInput[i + 1].toLowerCase();
                if (items.containsKey(element)) {
                    items.put(element, items.get(element) + count);
                    if (items.get(element) >= 250) {
                        items.put(element,items.get(element) - 250);
                        whichIsObtainItems(element);
                        isObtain = true;
                        break;
                    }
                } else {
                    junk.putIfAbsent(element, 0);
                    junk.put(element, junk.get(element) + count);
                }
            }

        }
        items
                .entrySet()
                .stream()
                .sorted((i1, i2) -> Integer.compare(i2.getValue(), i1.getValue()))
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));

        junk
                .forEach((k,v) -> System.out.printf("%s: %d%n",k,v));
    }

    private static void whichIsObtainItems(String element) {
        switch (element) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
    }
}
