package WorkingWithAbstraction;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class greedyTimes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());

        String[] quantities = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = readData(capacity, quantities);

        printResult(bag);
    }

    private static Map<String, Map<String, Long>> readData(long capacity, String[] quantities) {
        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        for (int i = 0; i < quantities.length; i += 2) {
            String name = quantities[i];
            long count = Long.parseLong(quantities[i + 1]);

            String value = "";

            if (name.length() == 3) {
                value = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                value = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                value = "Gold";
            }

            if (value.equals("")) {
                continue;
            } else if (capacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (value) {
                case "Gem":
                    if (!bag.containsKey(value)) {
                        if (addValue(bag, count, "Gold")) continue;
                    } else if (bag.get(value).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(value)) {
                        if (addValue(bag, count, "Gem")) continue;
                    } else if (bag.get(value).values().stream().mapToLong(e -> e).sum() + count > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(value)) {
                bag.put((value), new LinkedHashMap<>());
            }

            if (!bag.get(value).containsKey(name)) {
                bag.get(value).put(name, 0L);
            }

            bag.get(value).put(name, bag.get(value).get(name) + count);
        }
        return bag;
    }

    private static void printResult(Map<String, Map<String, Long>> bag) {
        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean addValue(Map<String, Map<String, Long>> bag, long count, String gold) {
        if (bag.containsKey(gold)) {
            if (count > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }
}