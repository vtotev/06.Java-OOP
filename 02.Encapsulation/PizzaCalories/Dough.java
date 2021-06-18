package Encapsulation.PizzaCalories;

import java.util.Arrays;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!Arrays.stream(FlourType.values()).anyMatch(o -> o.name().equals(flourType))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!Arrays.stream(BakingTechnique.values()).anyMatch(o -> o.name().equals(bakingTechnique))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double result = 0.0;
        result = (2 * weight) * FlourType.valueOf(flourType).multiplier * BakingTechnique.valueOf(bakingTechnique).multiplier;
        return result;
    }
}
