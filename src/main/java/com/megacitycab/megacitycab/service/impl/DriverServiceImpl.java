package com.megacitycab.megacitycab.service.impl;


import com.megacitycab.megacitycab.dto.DriverDTO;
import com.megacitycab.megacitycab.dto.UserDTO;
import com.megacitycab.megacitycab.entity.Driver;
import com.megacitycab.megacitycab.entity.User;
import com.megacitycab.megacitycab.enums.DriverStatus;
import com.megacitycab.megacitycab.enums.UserRoles;
import com.megacitycab.megacitycab.enums.UserStatus;
import com.megacitycab.megacitycab.repo.DriverRepo;
import com.megacitycab.megacitycab.repo.UserRepo;
import com.megacitycab.megacitycab.service.DriverService;
import com.megacitycab.megacitycab.service.UserService;
import com.megacitycab.megacitycab.service.mapper.DriverMapper;
import org.eclipse.angus.mail.imap.protocol.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DriverDTO saveAndUpdateDriver(DriverDTO dto) {
        Driver driver;
        if (dto.getId() == null || dto.getId() == 0) {
            dto.setStatus(DriverStatus.ACTIVE);

            dto.getUser().setRole(UserRoles.DRIVER);
            dto.getUser().setStatus(UserStatus.ACTIVE);

            User user = modelMapper.map(dto.getUser(), User.class);
            User isSaved = userRepo.save(user);
            dto.getUser().setId(isSaved.getId());

            driver = new DriverMapper().dtoToEntity(dto);
            driver.setUser(isSaved);
            driver = driverRepo.save(driver);
            dto.setId(driver.getId());
            return dto;
        } else {
            DriverStatus driverStatus = driverRepo.getStatus(dto.getId());
            if (!driverRepo.existsById(dto.getId()) || driverStatus.equals(DriverStatus.DELETED))
                throw new RuntimeException("Driver is not exists!");

            dto.setStatus(driverStatus);
            int userId = driverRepo.getUserId(dto.getId());
            User user = modelMapper.map(dto.getUser(), User.class);
            user.setId(userId);
            dto.getUser().setId(userId);

            User currentUser = userRepo.findById(userId).get();
            user.setStatus(currentUser.getStatus());
            user.setRole(currentUser.getRole());

            driver = new DriverMapper().dtoToEntity(dto);
            driver.setUser(user);
            driver = driverRepo.save(driver);
            dto.setId(driver.getId());
            return dto;
        }
    }
}
