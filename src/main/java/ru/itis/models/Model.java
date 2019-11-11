package ru.itis.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    private Long id;
    private String brand;
    private String name;
    private String color;
    private String type;

    public Model(String brand, String name, String color, String type) {
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.type = type;
    }
}
