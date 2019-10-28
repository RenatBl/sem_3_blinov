package ru.itis.models;

import lombok.*;
import ru.itis.models.enums.Status;

import java.sql.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
    private Long id;
    private User user;
    private Bike bike;
    private Station start;
    private Station finish;
    private Integer time;
    private Double cost;
    private Date startTime;
    private Date finishTime;
    private Status status;

    public Double getCost() {
        return bike.getPrice() * time;
    }

    public Integer getTime() {
        Integer hours = finishTime.getHours() - finishTime.getHours();
        if (hours > 1) {
            return hours;
        } else {
            return 1;
        }
    }
}
