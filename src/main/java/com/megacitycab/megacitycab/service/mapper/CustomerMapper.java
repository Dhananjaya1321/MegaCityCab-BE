package com.megacitycab.megacitycab.service.mapper;

import com.megacitycab.megacitycab.dto.CustomerDTO;
import com.megacitycab.megacitycab.entity.Customer;

public class CustomerMapper {
    public Customer dtoToEntity(CustomerDTO dto){
        Customer driver = new Customer();

        driver.setId(dto.getId());
        driver.setName(dto.getName());
        driver.setNic(dto.getNic());
        driver.setAddress(dto.getAddress());
        driver.setContact(dto.getContact());
        driver.setStatus(dto.getStatus());

        return driver;
    }
}
