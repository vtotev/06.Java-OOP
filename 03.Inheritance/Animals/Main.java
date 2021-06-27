package Inheritance.Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("Beast!")) {
            String animal = input;
            input = scan.nextLine();
            String[] data = input.trim().split(" ");
            try {
                Animal newAnimal = getAnimal(animal, data);
                System.out.println(newAnimal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scan.nextLine();
        }
    }

    private static Animal getAnimal(String animal, String[] data) {
        switch (animal) {
            case "Dog":
                return new Dog(data[0], Integer.parseInt(data[1]), data[2]);
            case "Cat":
                return new Cat(data[0], Integer.parseInt(data[1]), data[2]);
            case "Frog":
                return new Frog(data[0], Integer.parseInt(data[1]), data[2]);
            case "Kitten":
                return new Kitten(data[0], Integer.parseInt(data[1]));
            case "Tomcat":
                return new Tomcat(data[0], Integer.parseInt(data[1]));
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }
}
