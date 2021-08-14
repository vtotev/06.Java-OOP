package Polymorphism.Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public Animal(String name, String food) {
        this.name = name;
        this.favouriteFood = food;
    }

    public abstract String explainSelf();
}
