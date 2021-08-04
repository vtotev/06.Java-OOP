package InterfacesAndAbstraction.FoodShortage;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        Map<String, Buyer> buyer = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] input = scan.nextLine().split("\\s+");
            if (input.length == 4) {
                buyer.put(input[0], new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]));
            } else {
                buyer.put(input[0], new Rebel(input[0], Integer.parseInt(input[1]), input[2]));
            }
        }
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {
            if (buyer.containsKey(input)) {
                buyer.get(input).buyFood();
            }
            input = scan.nextLine();
        }
        System.out.println(buyer.entrySet().stream().mapToInt(o -> o.getValue().getFood()).sum());
    }
}
