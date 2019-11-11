package ru.itis.models;

import lombok.*;
import ru.itis.models.enums.Available;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    private Long id;
    private Integer year;
    private Double price;
    private Available available;
    private Long model_id;
    private Long station_id;

    public Bike(Integer year, Double price, Available available, Long model_id, Long station_id) {
        this.year = year;
        this.price = price;
        this.available = available;
        this.model_id = model_id;
        this.station_id = station_id;
    }

    public boolean isAvailable() {
        return available.name().equals("FREE");
    }
}

