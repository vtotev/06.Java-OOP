package DesignPatterns.Builder;

public class Main {
    public static void main(String[] args) {
        Car newCar = new Car().withFancyRims(true).withColor("purple");
        System.out.println(newCar);

        Car Car = new Car().withElectricCharge(true).withLightsColor("white");
        System.out.println(Car);
    }
}
