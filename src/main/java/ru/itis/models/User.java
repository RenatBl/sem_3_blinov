package ru.itis.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public User(String username, String password, String name, String surname, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
