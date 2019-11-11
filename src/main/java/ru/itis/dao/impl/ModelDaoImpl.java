package ru.itis.dao.impl;

import ru.itis.dao.ModelDao;
import ru.itis.dao.RowMapper;
import ru.itis.models.Model;
import ru.itis.services.ConnectionService;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ModelDaoImpl implements ModelDao {
    private Connection connection;
    private RowMapper<Model> stationRowMapper = row -> {
        Long id = row.getLong("id");
        String brand = row.getString("brand");
        String name = row.getString("name");
        String color = row.getString("color");
        String type = row.getString("type");
        return new Model(id, brand, name, color, type);
    };

    public ModelDaoImpl() {
        this.connection = ConnectionService.getConnection();
    }

    @Override
    public Optional<Model> find(Long id) {
        Model model = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM models WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                model = stationRowMapper.mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return Optional.ofNullable(model);
    }

    @Override
    public void save(Model model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO models (brand, name, color, type) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getBrand());
            statement.setString(2, model.getName());
            statement.setString(3, model.getColor());
            statement.setString(4, model.getType());
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
