package bakery.repositories;

import bakery.entities.tables.BaseTable;
import bakery.repositories.interfaces.TableRepository;

import java.util.Collection;

public class TableRepositoryImpl implements TableRepository {

    private Collection<BaseTable> models;


    @Override
    public Object getByNumber(int number) {
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
