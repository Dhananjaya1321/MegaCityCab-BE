package com.megacitycab.megacitycab.service.impl;


import com.megacitycab.megacitycab.dto.CustomerDTO;
import com.megacitycab.megacitycab.dto.DriverDTO;
import com.megacitycab.megacitycab.entity.Customer;
import com.megacitycab.megacitycab.entity.Driver;
import com.megacitycab.megacitycab.entity.User;
import com.megacitycab.megacitycab.enums.CustomerStatus;
import com.megacitycab.megacitycab.enums.DriverStatus;
import com.megacitycab.megacitycab.enums.UserRoles;
import com.megacitycab.megacitycab.enums.UserStatus;
import com.megacitycab.megacitycab.repo.CustomerRepo;
import com.megacitycab.megacitycab.repo.UserRepo;
import com.megacitycab.megacitycab.service.CustomerService;
import com.megacitycab.megacitycab.service.DriverService;
import com.megacitycab.megacitycab.service.mapper.CustomerMapper;
import com.megacitycab.megacitycab.service.mapper.DriverMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO saveAndUpdateCustomer(CustomerDTO dto) {
        Customer customer;
        if (dto.getId() == null || dto.getId() == 0) {
            dto.setStatus(CustomerStatus.ACTIVE);

            dto.getUser().setRole(UserRoles.CUSTOMER);
            dto.getUser().setStatus(UserStatus.ACTIVE);

            User user = modelMapper.map(dto.getUser(), User.class);
            User isSaved = userRepo.save(user);
            dto.getUser().setId(isSaved.getId());

            customer = new CustomerMapper().dtoToEntity(dto);
            customer.setUser(isSaved);
            customer = customerRepo.save(customer);
            dto.setId(customer.getId());
            return dto;
        } else {
            CustomerStatus customerStatus = customerRepo.getStatus(dto.getId());
            if (!customerRepo.existsById(dto.getId()) || customerStatus.equals(CustomerStatus.DELETED))
                throw new RuntimeException("Customer is not exists!");

            dto.setStatus(customerStatus);
            int userId = customerRepo.getUserId(dto.getId());
            User user = modelMapper.map(dto.getUser(), User.class);
            user.setId(userId);
            dto.getUser().setId(userId);

            User currentUser = userRepo.findById(userId).get();
            user.setStatus(currentUser.getStatus());
            user.setRole(currentUser.getRole());

            customer = new CustomerMapper().dtoToEntity(dto);
            customer.setUser(user);
            customer = customerRepo.save(customer);
            dto.setId(customer.getId());
            return dto;
        }
    }
}
