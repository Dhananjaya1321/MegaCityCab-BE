package com.megacitycab.megacitycab.repo;

import com.megacitycab.megacitycab.entity.Customer;
import com.megacitycab.megacitycab.enums.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT c.status FROM Customer c WHERE c.id=:id")
    CustomerStatus getStatus(Integer id);

    @Query(value = "SELECT u.id FROM Customer c LEFT JOIN User u ON c.user.id=u.id WHERE c.id=:id")
    int getUserId(Integer id);
}
