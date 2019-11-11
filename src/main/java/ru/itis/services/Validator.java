package ru.itis.services;

import ru.itis.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Validator {
    public static synchronized List<String> validate(String name, String password, Optional<User> user){
        HashingPassword hashingPassword = new HashingPassword();
        List<String> errors = new ArrayList<>();
        if (user.isPresent()) {
            User user1 = user.get();
            try {
                if (!user1.getName().equals(name) && hashingPassword.check(password, user1.getPassword())) {
                    errors.add("Неверный логин или пароль");
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            errors.add("Пользователя не существует, пожалуйста, зарегистрируйтесь)");
        }
        return errors;
    }
}