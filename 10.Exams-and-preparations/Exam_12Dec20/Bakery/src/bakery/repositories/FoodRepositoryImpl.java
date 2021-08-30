package bakery.repositories;

import bakery.entities.bakedFoods.BaseFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository {
    private Collection<BaseFood> models;

        @Override
    public Object getByName(String name) {
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public void add(Object o) {

    }
}
