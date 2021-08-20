package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        DecimalFormat df = new DecimalFormat("###.##");
        double fuelNeeded = distance * (getFuelConsumption() + 0.9);
        if (fuelNeeded > getFuelQuantity()) {
            return "Car needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        return String.format("Car travelled %s km", df.format(distance));
    }

    @Override
    public void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }

}
