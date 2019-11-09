package ru.itis.dao.impl;

import ru.itis.dao.RowMapper;
import ru.itis.dao.UserDao;
import ru.itis.models.User;
import ru.itis.services.ConnectionService;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private Connection connection;
    private RowMapper<User> userFindRowMapper = row -> {
        Long id = row.getLong("id");
        String username = row.getString("username");
        String password = row.getString("password");
        String name = row.getString("name");
        String surname = row.getString("surname");
        String phoneNumber = row.getString("phoneNumber");
        String email = row.getString("email");
        return new User(id, username, password, name, surname, phoneNumber, email);
    };

    public UserDaoImpl() {
        this.connection = ConnectionService.getConnection();
    }

    @Override
    public Optional<User> find(Long id) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = userFindRowMapper.mapRow(resultSet);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User model) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO users (username, password, name, surname, phoneNumber, email) VALUES (?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getUsername());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getName());
            statement.setString(4, model.getSurname());
            statement.setString(5, model.getPhoneNumber());
            statement.setString(6, model.getEmail());
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
    public void update(User model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users")) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                users.add(userFindRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return users;
    }
}
