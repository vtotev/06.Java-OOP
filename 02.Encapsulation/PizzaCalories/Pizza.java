package Encapsulation.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setToppings(int numOfToppings) {
        if (numOfToppings < 0 || numOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        toppings = new ArrayList<>();
        this.numOfToppings = numOfToppings;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        if (toppings.size() < this.numOfToppings) {
            toppings.add(topping);
        }
    }

    public double getOverallCalories () {
        double result = 0.0;
        for (Topping top : toppings) {
            result += top.calculateCalories();
        }
        result += dough.calculateCalories();
        return result;
    }
}
