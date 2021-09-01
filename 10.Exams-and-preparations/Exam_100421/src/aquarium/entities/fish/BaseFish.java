package aquarium.entities.fish;

import static aquarium.common.ExceptionMessages.*;

public abstract class BaseFish implements Fish{
    private String name;
    private String species;
    private int size;
    private double price;

    protected BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        setPrice(price);
    }

    private void setSpecies(String species) {
        checkStringNullEmpty(species, SPECIES_NAME_NULL_OR_EMPTY);
        this.species = species;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    public void setName(String name) {
        checkStringNullEmpty(name, FISH_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    @Override
    public void eat() {
        this.size += 5;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    private void checkStringNullEmpty(String species, String excMsg) {
        if (species == null || species.trim().isEmpty()) {
            throw new NullPointerException(excMsg);
        }
    }

}
