package com.megacitycab.megacitycab.dto;

import com.megacitycab.megacitycab.entity.User;
import com.megacitycab.megacitycab.enums.DriverStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {
    private Integer id;
    private String name;
    private String nic;
    private String address;
    private String contact;
    private DriverStatus status;
    private LocalDateTime lastUpdate;

    private UserDTO user;

}
