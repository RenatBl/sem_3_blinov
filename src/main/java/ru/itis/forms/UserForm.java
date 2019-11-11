package ru.itis.forms;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    Long id;
    String parameter;
    Long ownerId;

    public UserForm(String parameter, Long ownerId) {
        this.parameter = parameter;
        this.ownerId = ownerId;
    }
}
