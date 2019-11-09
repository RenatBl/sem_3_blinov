package ru.itis.dao.impl;

import ru.itis.dao.ModelDao;
import ru.itis.models.Model;

import java.util.List;
import java.util.Optional;

public class ModelDaoImpl implements ModelDao {
    @Override
    public Optional<Model> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Model model) {

    }

    @Override
    public void update(Model model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Model> findAll() {
        return null;
    }
}
