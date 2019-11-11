package ru.itis.models;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    private Long id;
    private String name;

    public Station(String name) {
        this.name = name;
    }
}
