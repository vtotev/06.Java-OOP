package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        decorations = new ArrayList<>();
        fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() >= capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish: this.fish) {
            fish.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", getName(), getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Fish: ");
        StringBuilder sbFishes = new StringBuilder();
        if (fish.isEmpty()) {
            sb.append("none");
        } else {
            this.fish.forEach(f -> sbFishes.append(f.getName()+" "));
        }
        sb.append(sbFishes.toString().trim())
                .append(System.lineSeparator())
                .append("Decorations: " + decorations.size())
                .append(System.lineSeparator())
                .append("Comfort: " + calculateComfort());
        return sb.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return Collections.unmodifiableCollection(this.fish);
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(this.decorations);
    }
}
