package ru.itis.models;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String text;
    private Long userId;
    private LocalDateTime date;

    public Comment(String text, Long userId, LocalDateTime date) {
        this.text = text;
        this.userId = userId;
        this.date = date;
    }
}
