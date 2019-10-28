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
}
