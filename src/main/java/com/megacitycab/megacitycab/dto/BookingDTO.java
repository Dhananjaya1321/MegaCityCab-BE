package com.megacitycab.megacitycab.dto;

import com.megacitycab.megacitycab.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Integer id;
    private String pickup_location;
    private String destination;
    private double Kilometers_count_between_pickup_location_and_destination;
    private LocalDate pick_up_date;
    private LocalTime pick_up_time;

    private BookingStatus status;

    private LocalDateTime lastUpdate;
}
