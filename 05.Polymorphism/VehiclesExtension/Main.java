package Polymorphism.VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Integer.parseInt(input[3]));
        input = scan.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Integer.parseInt(input[3]));
        input = scan.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(input[1]), Double.parseDouble(input[2]), Integer.parseInt(input[3]));
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            input = scan.nextLine().split("\\s+");
            try {
                switch (input[0]) {
                    case "Drive":
                        switch (input[1]) {
                            case "Car":
                                System.out.println(car.drive(Double.parseDouble(input[2])));
                                break;
                            case "Truck":
                                System.out.println(truck.drive(Double.parseDouble(input[2])));
                                break;
                            case "Bus":
                                System.out.println(bus.drive(Double.parseDouble(input[2])));
                                break;
                        }
                        break;
                    case "DriveEmpty":
                        System.out.println(bus.driveEmpty(Double.parseDouble(input[2])));
                        break;
                    case "Refuel":
                        switch (input[1]) {
                            case "Car":
                                car.refuel(Double.parseDouble(input[2]));
                                break;
                            case "Truck":
                                truck.refuel(Double.parseDouble(input[2]) * 0.95);
                                break;
                            case "Bus":
                                bus.refuel(Double.parseDouble(input[2]));
                                break;
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.printf("Car: %.2f%nTruck: %.2f%nBus: %.2f%n", car.getFuelQuantity(), truck.getFuelQuantity(),
                bus.getFuelQuantity());
    }
}