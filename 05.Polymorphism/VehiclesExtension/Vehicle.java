package Polymorphism.VehiclesExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private int fuelCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, int fuelCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract String drive(double distance);
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (getFuelQuantity() + liters > getFuelCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        setFuelQuantity(getFuelQuantity() + liters);
    }
}
