package Encapsulation.PizzaCalories;

public enum FlourType {
    White (1.5),
    Wholegrain (1.0);

    double multiplier;

    FlourType (double multiplier) {
        this.multiplier = multiplier;
    }

}
