package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public String drive(double distance) {
        DecimalFormat df = new DecimalFormat("###.##");
        double fuelNeeded = distance * (getFuelConsumption() + 1.6);
        if (fuelNeeded > getFuelQuantity()) {
            return "Truck needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        return String.format("Truck travelled %s km", df.format(distance));
    }

    @Override
    public void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + (liters * 0.95));
    }
}
