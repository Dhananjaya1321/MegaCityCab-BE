package com.megacitycab.megacitycab.controller;

import com.megacitycab.megacitycab.dto.CustomerDTO;
import com.megacitycab.megacitycab.dto.DriverDTO;
import com.megacitycab.megacitycab.service.CustomerService;
import com.megacitycab.megacitycab.util.ExceptionHandler;
import com.megacitycab.megacitycab.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResponseUtil> saveAndUpdateCustomer(
            @RequestBody CustomerDTO dto
    ) {
        try {
            String msg = (dto.getId() == null || dto.getId()==0) ? "Customer saved successfully." : "Customer updated successfully.";
            return ResponseEntity.ok(new ResponseUtil(HttpStatus.OK, msg, customerService.saveAndUpdateCustomer(dto)));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            if (e.getMessage().equals("Customer is not exists!"))
                return com.megacitycab.megacitycab.util.ExceptionHandler.handleCustomException(HttpStatus.NOT_FOUND, e);

            return ExceptionHandler.handleException(e);
        }
    }
}
