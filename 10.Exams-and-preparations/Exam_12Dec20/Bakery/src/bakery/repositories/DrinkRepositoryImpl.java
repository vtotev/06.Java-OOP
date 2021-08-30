package bakery.repositories;

import bakery.entities.drinks.BaseDrink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.Collection;

public class DrinkRepositoryImpl implements DrinkRepository {
    private Collection<BaseDrink> models;

    @Override
    public Object getByNameAndBrand(String drinkName, String drinkBrand) {
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
