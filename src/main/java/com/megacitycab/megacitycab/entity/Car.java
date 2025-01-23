package com.megacitycab.megacitycab.entity;

import com.megacitycab.megacitycab.enums.CarStatus;
import com.megacitycab.megacitycab.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registration_number;
    private String brand;
    private String color;
    private String fuel_type;
    private int number_of_passengers;
    private String type;

    private String front_image;
    private String interior_image;
    private String back_image;
    private String side_image;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    private String createdBy;
    private String updatedBy;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "id.car")
    private List<DriverAndCarDetails> driverAndCarDetails;
}
