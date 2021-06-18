package Encapsulation.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split("\\s+");
        try {
            if (tokens.length < 3) {
                throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
            }
            Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));
            tokens = scan.nextLine().split("\\s+");
            pizza.setDough(new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3])));
            String input = scan.nextLine();
            while (!input.equals("END")) {
                tokens = input.split("\\s+");
                pizza.addTopping(new Topping(tokens[1], Double.parseDouble(tokens[2])));
                input = scan.nextLine();
            }
            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
