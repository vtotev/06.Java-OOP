package Encapsulation.PizzaCalories;

public enum BakingTechnique {
    Crispy (0.9),
    Chewy (1.1),
    Homemade (1.0);

    double multiplier;

    BakingTechnique (double multiplier) {
        this.multiplier = multiplier;
    }
}
