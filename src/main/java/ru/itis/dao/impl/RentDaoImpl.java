package ru.itis.dao.impl;

import ru.itis.dao.RentDao;
import ru.itis.models.Rent;

import java.util.List;
import java.util.Optional;

public class RentDaoImpl implements RentDao {
    @Override
    public Optional<Rent> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Rent model) {

    }

    @Override
    public void update(Rent model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Rent> findAll() {
        return null;
    }
}
