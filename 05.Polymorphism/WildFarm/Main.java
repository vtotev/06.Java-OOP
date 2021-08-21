package Polymorphism.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        List<Animal> animals = new ArrayList<>();
        while (!"End".equals(line = scan.nextLine())) {
            String[] animalData = line.split("\\s+");
            Animal animal = null;
            line = scan.nextLine();
            String[] foodData = line.split("\\s+");
            switch (animalData[0]) {
                case "Cat":
                    animal = new Cat(animalData[1], animalData[0], Double.parseDouble(animalData[2]),
                            animalData[3], animalData[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(animalData[1], animalData[0], Double.parseDouble(animalData[2]),
                            animalData[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(animalData[1], animalData[0], Double.parseDouble(animalData[2]),
                            animalData[3]);
                    break;
                case "Mouse":
                    animal = new Mouse(animalData[1], animalData[0], Double.parseDouble(animalData[2]),
                            animalData[3]);
                    break;
            }
            try {
                switch (foodData[0]) {
                    case "Vegetable":
                        Food vegetable = new Vegetable(Integer.parseInt(foodData[1]));
                        animal.makeSound();
                        animal.eatFood(vegetable);
                        break;
                    case "Meat":
                        Food meat = new Meat(Integer.parseInt(foodData[1]));
                        animal.makeSound();
                        animal.eatFood(meat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (animal != null) {
                animals.add(animal);
            }
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
