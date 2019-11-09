package ru.itis.dao.impl;

import ru.itis.dao.BikeDao;
import ru.itis.models.Bike;

import java.util.List;
import java.util.Optional;

public class BikeDaoImpl implements BikeDao {
    @Override
    public Optional<Bike> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Bike model) {

    }

    @Override
    public void update(Bike model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Bike> findAll() {
        return null;
    }
}
