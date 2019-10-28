package ru.itis.models;

import lombok.*;
import ru.itis.models.enums.Available;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    private Long id;
    private Model model;
    private Integer year;
    private Double price;
    private Available available;

    public boolean isAvailable(){
        if (available.name().equals(Available.FREE.name())) {
            return true;
        } else {
            return false;
        }
    }
}
