package ru.itis.dao.impl;

import ru.itis.dao.RowMapper;
import ru.itis.forms.UserForm;
import ru.itis.services.ConnectionService;

import java.sql.*;
import java.util.Optional;

public class UserFormDao {
    private Connection connection;

    public UserFormDao() {
        this.connection = ConnectionService.getConnection();
    }

    private RowMapper<UserForm> authCookieRowMapper = row -> {
        String parameter = row.getString("parameter");
        Long ownerId = row.getLong(3);
        return new UserForm(parameter, ownerId);
    };

    public void delete(Long id) {
        if (id < 0L) throw new IllegalArgumentException();
        try (Statement statement = connection.createStatement()) {
            int updRows = statement.executeUpdate("DELETE from users_cookies where owner_id = id");
            if (updRows == 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<UserForm> findById(Long id) {
        UserForm user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users_cookies WHERE owner_id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = authCookieRowMapper.mapRow(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    public Optional<UserForm> findByParameter(String parameter) {
        UserForm user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users_cookies WHERE parameter = ? ")) {
            statement.setString(1, parameter);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = authCookieRowMapper.mapRow(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    public void save(UserForm model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO users_cookies (parameter, owner_id) VALUES (?,?) ",
                Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, model.getParameter());
            statement.setLong(2, model.getOwnerId());
            int updRows;
            updRows = statement.executeUpdate();
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
}