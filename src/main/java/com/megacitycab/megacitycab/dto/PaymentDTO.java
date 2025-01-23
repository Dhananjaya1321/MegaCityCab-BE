package com.megacitycab.megacitycab.dto;

import com.megacitycab.megacitycab.enums.PaymentStatus;
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
public class PaymentDTO {
    private Integer id;
    private double driver_fee;
    private int mileage;
    private LocalDate payment_date;
    private LocalTime payment_time;
    private String payment_type;
    private double total;

    private PaymentStatus status;

    private String createdBy;
    private String updatedBy;

    private LocalDateTime lastUpdate;
}
