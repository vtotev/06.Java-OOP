package InterfacesAndAbstraction.CarShop;

import java.io.Serializable;

public class Seat implements Car, Serializable {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, int horsePower, String countryProduced) {
        setModel(model);
        setColor(color);
        setHorsePower(horsePower);
        this.countryProduced = countryProduced;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                getModel(), countryProduced(), Car.TIRES);
    }
}
