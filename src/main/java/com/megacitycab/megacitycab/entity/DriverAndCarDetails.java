package com.megacitycab.megacitycab.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "driver_and_car_details")
public class DriverAndCarDetails {
    @EmbeddedId
    private DriverAndCarDetailsIds id;
}
