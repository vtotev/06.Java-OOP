package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        decorations = new DecorationRepository();
        aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;

            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;

            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;

            case "Plant":
                decoration = new Plant();
                break;

            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration dec = decorations.findByType(decorationType);
        if (dec == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        aquarium.addDecoration(dec);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;

            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;

            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        Aquarium currAquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        if (currAquarium.getClass().getSimpleName().equals("FreshwaterAquarium") && fish.getClass().getSimpleName().equals("FreshwaterFish")) {
            currAquarium.addFish(fish);
        } else if (currAquarium.getClass().getSimpleName().equals("SaltwaterAquarium") && fish.getClass().getSimpleName().equals("SaltwaterFish")) {
            currAquarium.addFish(fish);
        } else {
            return WATER_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        if (aquarium != null) {
            aquarium.feed();
        }
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        double sum = 0.0;
        if (aquarium != null) {
            sum += aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
            sum += aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        }
        return String.format(VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aq : aquariums) {
            sb.append(aq.getInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
