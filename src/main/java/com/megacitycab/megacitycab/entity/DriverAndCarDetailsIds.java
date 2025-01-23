package com.megacitycab.megacitycab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DriverAndCarDetailsIds implements Serializable {
    @ManyToOne
    @JoinColumn(name = "cid")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "did")
    private Driver driver;
}
