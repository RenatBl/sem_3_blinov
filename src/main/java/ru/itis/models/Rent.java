package ru.itis.models;

import lombok.*;
import ru.itis.models.enums.Status;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
    private Long id;
    private Long user_id;
    private Long bike_id;
    private Long start_station_id;
    private Integer time;
    private Double cost;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private Status status;

    public Rent(Long user_id, Long bike_id, Long start_station_id, Integer time, Double cost, LocalDateTime startTime,
                LocalDateTime finishTime, Status status) {
        this.user_id = user_id;
        this.bike_id = bike_id;
        this.start_station_id = start_station_id;
        this.time = time;
        this.cost = cost;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
    }

    public Boolean isPaid() {
        return status.name().equals("PAID");
    }
}