package com.megacitycab.megacitycab.entity;

import com.megacitycab.megacitycab.enums.BookingStatus;
import com.megacitycab.megacitycab.enums.CarStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pickup_location;
    private String destination;
    private double Kilometers_count_between_pickup_location_and_destination;
    private LocalDate pick_up_date;
    private LocalTime pick_up_time;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Car car;


}
