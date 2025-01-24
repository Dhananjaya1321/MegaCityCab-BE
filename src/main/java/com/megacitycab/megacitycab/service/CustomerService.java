package com.megacitycab.megacitycab.service;


import com.megacitycab.megacitycab.dto.CustomerDTO;

public interface CustomerService {

    CustomerDTO saveAndUpdateCustomer(CustomerDTO dto);
}
