package com.megacitycab.megacitycab.service.mapper;

import com.megacitycab.megacitycab.dto.DriverDTO;
import com.megacitycab.megacitycab.entity.Driver;

public class DriverMapper {
    public Driver dtoToEntity(DriverDTO dto){
        Driver driver = new Driver();

        driver.setId(dto.getId());
        driver.setName(dto.getName());
        driver.setNic(dto.getNic());
        driver.setAddress(dto.getAddress());
        driver.setContact(dto.getContact());
        driver.setStatus(dto.getStatus());

        return driver;
    }
}
