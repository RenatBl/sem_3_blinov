package ru.itis.dao;

import ru.itis.models.Bike;

import java.util.List;

public interface BikeDao extends CrudDao<Bike> {
    List<Bike> findAllByStationId(Long id);
}
