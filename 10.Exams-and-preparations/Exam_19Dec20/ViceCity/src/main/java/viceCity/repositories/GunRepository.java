package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.*;

public class GunRepository implements Repository<Gun> {

    private Collection<Gun> models;

    public GunRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Gun model) {
        if (!models.contains(model)) {
            models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return models.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
