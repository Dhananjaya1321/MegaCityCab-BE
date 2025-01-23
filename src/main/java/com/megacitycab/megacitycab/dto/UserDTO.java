package com.megacitycab.megacitycab.dto;

import com.megacitycab.megacitycab.enums.UserRoles;
import com.megacitycab.megacitycab.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String email;
    private String username;
    private String password;

    private UserRoles role;

    private UserStatus status;

    private String createdBy;
    private String updatedBy;

    private LocalDateTime lastUpdate;
}
