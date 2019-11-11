package ru.itis.dao.impl;

import ru.itis.dao.BikeDao;
import ru.itis.dao.RowMapper;
import ru.itis.models.Bike;
import ru.itis.models.enums.Available;
import ru.itis.services.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BikeDaoImpl implements BikeDao {
    private Connection connection;
    private RowMapper<Bike> bikeRowMapper = row -> {
        Long id = row.getLong("id");
        Integer year = row.getInt("year");
        Double price = row.getDouble("price");
        Available available = Available.valueOf(row.getString("available"));
        Long model_id = row.getLong("model_id");
        Long station_id = row.getLong("station_id");
        return new Bike(id, year, price, available, model_id, station_id);
    };

    public BikeDaoImpl() {
        this.connection = ConnectionService.getConnection();
    }
    @Override
    public Optional<Bike> find(Long id) {
        Bike bike = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM bikes WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                bike = bikeRowMapper.mapRow(resultSet);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return Optional.ofNullable(bike);
    }

    @Override
    public void save(Bike model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO bikes (year, price, available, model_id, station_id) VALUES (?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, model.getYear());
            statement.setDouble(2, model.getPrice());
            statement.setString(3, model.getAvailable().name());
            statement.setLong(4, model.getModel_id());
            statement.setLong(5, model.getStation_id());
            int updRows = statement.executeUpdate();
            if (updRows == 0) {
                throw new SQLException();
            }
            try (ResultSet set = statement.getGeneratedKeys()) {
                if (set.next()) {
                    model.setId(set.getLong(1));
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(Bike model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Bike> findAll() {
        List<Bike> bikes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM bikes")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bikes.add(bikeRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return bikes;
    }

    @Override
    public List<Bike> findAllByStationId(Long id) {
        List<Bike> bikes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM bikes WHERE station_id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bikes.add(bikeRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return bikes;
    }
}
