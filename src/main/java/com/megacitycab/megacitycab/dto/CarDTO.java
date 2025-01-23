package com.megacitycab.megacitycab.dto;

import com.megacitycab.megacitycab.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private Integer id;
    private String registration_number;
    private String brand;
    private String color;
    private String fuel_type;
    private int number_of_passengers;
    private String type;

    private double price_per_km;

    private String front_image;
    private String interior_image;
    private String back_image;
    private String side_image;

    private CarStatus status;

    private String createdBy;
    private String updatedBy;

    private LocalDateTime lastUpdate;

}
