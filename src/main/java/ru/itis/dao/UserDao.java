package ru.itis.dao;

import ru.itis.models.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    Optional<User> findByUserName(String name);
}
