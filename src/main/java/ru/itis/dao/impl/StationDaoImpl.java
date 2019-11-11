package ru.itis.dao.impl;

import ru.itis.dao.RowMapper;
import ru.itis.dao.StationDao;
import ru.itis.models.Station;
import ru.itis.services.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StationDaoImpl implements StationDao {
    private Connection connection;
    private RowMapper<Station> stationRowMapper = row -> {
        Long id = row.getLong("id");
        String name = row.getString("name");
        return new Station(id, name);
    };

    public StationDaoImpl() {
        this.connection = ConnectionService.getConnection();
    }

    @Override
    public Optional<Station> find(Long id) {
        Station station = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM stations WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                station = stationRowMapper.mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return Optional.ofNullable(station);
    }

    @Override
    public void save(Station model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO stations (name) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getName());
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
    public void update(Station model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Station> findAll() {
        List<Station> stations = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM stations")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stations.add(stationRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return stations;
    }
}
