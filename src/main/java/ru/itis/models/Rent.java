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
    private Integer time;
    private Double cost;
    private Date startTime;
    private Date finishTime;
    private Status status;

    public Boolean isPaid() {
        return status.name().equals("PAID");
    }
}