package ru.itis.dao.impl;

import ru.itis.dao.RentDao;
import ru.itis.dao.RowMapper;
import ru.itis.models.Rent;
import ru.itis.models.User;
import ru.itis.models.enums.Status;
import ru.itis.services.ConnectionService;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentDaoImpl implements RentDao {
    private Connection connection;

    private RowMapper<Rent> rentRowMapper = row -> {
        Long id = row.getLong("id");
        Long user_id = row.getLong("user_id");
        Long bike_id = row.getLong("bike_id");
        Long start_station_id = row.getLong("start_station_id");
        Integer time = row.getInt("time");
        Double cost = row.getDouble("cost");
        LocalDateTime start_time = row.getObject("7", LocalDateTime.class);
        LocalDateTime finish_time = row.getObject("8", LocalDateTime.class);
        Status status = Status.valueOf(row.getString("status"));
        return new Rent(id, user_id, bike_id, start_station_id, time, cost, start_time, finish_time, status);
    };

    public RentDaoImpl() {
        this.connection = ConnectionService.getConnection();
    }

    @Override
    public Optional<Rent> find(Long id) {
        Rent rent = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM rents WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rent = rentRowMapper.mapRow(resultSet);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return Optional.ofNullable(rent);
    }
    private final String SQL_INSERT = "INSERT INTO users (user_id, bike_id, start_station_id, time, cost, start_time, " +
            "finish_time, status) VALUES (?,?,?,?,?,?,?,?)";
    @Override
    public void save(Rent model) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, model.getUser_id());
            statement.setLong(2, model.getBike_id());
            statement.setLong(3, model.getStart_station_id());
            statement.setInt(4, model.getTime());
            statement.setDouble(5, model.getCost());
            statement.setObject(6, model.getStartTime());
            statement.setObject(7, model.getFinishTime());
            statement.setString(8, model.getStatus().name());
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

    private final String SQL_UPDATE = "UPDATE rents SET user_id = ?, bike_id = ?, start_station_id = ?, time = ?, " +
            "cost = ?, start_time = ?, finish_time = ?, status = ?  WHERE id = ?";
    @Override
    public void update(Rent model) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            //На место соответвующих вопросительных знаков уставнавливаем параметры модели, которую мы хотим обновить
            statement.setLong(1, model.getUser_id());
            statement.setLong(2, model.getBike_id());
            statement.setLong(3, model.getStart_station_id());
            statement.setInt(4, model.getTime());
            statement.setDouble(5, model.getCost());
            statement.setObject(6, model.getStartTime());
            statement.setObject(7, model.getFinishTime());
            statement.setString(8, model.getStatus().name());
            statement.setLong(9, model.getId());

            int updRows = statement.executeUpdate();

            if (updRows == 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Rent> findAll() {
        List<Rent> rents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM rents")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rents.add(rentRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return rents;
    }
}
