package Polymorphism.VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, int fuelCapacity) {
        super(fuelQuantity, fuelConsumption, fuelCapacity);
    }

    @Override
    public String drive(double distance) {
        DecimalFormat df = new DecimalFormat("###.##");
        double fuelNeeded = distance * (getFuelConsumption() + 1.4);
        if (fuelNeeded > getFuelQuantity()) {
            return "Bus needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        return String.format("Bus travelled %s km", df.format(distance));
    }

    public String driveEmpty(double distance) {
        DecimalFormat df = new DecimalFormat("###.##");
        double fuelNeeded = distance * getFuelConsumption();
        if (fuelNeeded > getFuelQuantity()) {
            return "Bus needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        return String.format("Bus travelled %s km", df.format(distance));
    }

}
