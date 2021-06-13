package Encapsulation.ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scab = new Scanner(System.in);
        double length = Double.parseDouble(scab.nextLine());
        double width = Double.parseDouble(scab.nextLine());
        double height = Double.parseDouble(scab.nextLine());
        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.calculateVolume());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
