package ru.itis.dao.impl;

import ru.itis.dao.CommentDao;
import ru.itis.dao.RowMapper;
import ru.itis.models.Comment;
import ru.itis.services.ConnectionService;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentDaoImpl implements CommentDao {
    private Connection connection;

    public CommentDaoImpl() {
        this.connection = ConnectionService.getConnection();
    }

    private RowMapper<Comment> commentRowMapper = row -> {
        Long id = row.getLong("id");
        String text = row.getString("text");
        Long userId = row.getLong("user_id");
        LocalDateTime date = row.getObject(4, LocalDateTime.class);
        return new Comment(id, text, userId, date);
    };

    @Override
    public Optional<Comment> find(Long id) {
        Comment comment = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM comments WHERE id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                comment = commentRowMapper.mapRow(resultSet);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return Optional.ofNullable(comment);
    }

    @Override
    public void save(Comment model) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO comments (text, user_id, pub_date) VALUES (?,?,?);",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, model.getText());
            statement.setLong(2, model.getUserId());
            statement.setObject(3, LocalDateTime.now());
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
    public void update(Comment model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM comments")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                comments.add(commentRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return comments;
    }
}
