package ru.itis.models;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    private Long id;
    private String name;
    private Set<Bike> bikes;
}
