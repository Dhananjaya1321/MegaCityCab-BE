package com.megacitycab.megacitycab.entity;

import com.megacitycab.megacitycab.enums.PaymentStatus;
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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double driver_fee;
    private int mileage;
    private LocalDate payment_date;
    private LocalTime payment_time;
    private String payment_type;
    private double total;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @OneToOne(cascade = CascadeType.ALL)
    private Booking booking;

}
