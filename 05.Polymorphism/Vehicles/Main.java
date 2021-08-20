package Polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        input = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            input = scan.nextLine().split("\\s+");
            switch (input[0]) {
                case "Drive":
                    switch (input[1]) {
                        case "Car":
                            System.out.println(car.drive(Double.parseDouble(input[2])));
                            break;
                        case "Truck":
                            System.out.println(truck.drive(Double.parseDouble(input[2])));
                            break;
                    }
                    break;
                case "Refuel":
                    switch (input[1]) {
                        case "Car":
                            car.refuel(Double.parseDouble(input[2]));
                            break;
                        case "Truck":
                            truck.refuel(Double.parseDouble(input[2]));
                            break;
                    }
                    break;
            }
        }
        System.out.printf("Car: %.2f%nTruck: %.2f%n", car.getFuelQuantity(), truck.getFuelQuantity());
    }
}