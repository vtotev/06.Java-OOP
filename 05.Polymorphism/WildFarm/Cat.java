package Polymorphism.WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;
    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                breed,
                new DecimalFormat("#.##").format(getAnimalWeight()),
                super.getLivingRegion(),
                getFoodEaten());
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }
}
