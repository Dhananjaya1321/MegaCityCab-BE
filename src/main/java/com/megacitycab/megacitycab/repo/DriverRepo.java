package com.megacitycab.megacitycab.repo;

import com.megacitycab.megacitycab.entity.Driver;
import com.megacitycab.megacitycab.entity.User;
import com.megacitycab.megacitycab.enums.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver, Integer> {
    @Query(value = "SELECT d.status FROM Driver d WHERE d.id=:id")
    DriverStatus getStatus(Integer id);

    @Query(value = "SELECT u.id FROM Driver d LEFT JOIN User u ON d.user.id=u.id WHERE d.id=:id")
    int getUserId(Integer id);

    @Modifying
    @Query(value = "UPDATE Driver d SET d.status='DELETED' WHERE d.id=:id")
    int deleteDriver(Integer id);
}
