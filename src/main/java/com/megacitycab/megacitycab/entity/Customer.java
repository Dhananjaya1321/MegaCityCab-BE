package com.megacitycab.megacitycab.entity;

import com.megacitycab.megacitycab.enums.CustomerStatus;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nic;
    private String address;
    private String contact;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;
}
