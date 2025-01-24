package com.megacitycab.megacitycab.controller;


import com.megacitycab.megacitycab.dto.DriverDTO;
import com.megacitycab.megacitycab.service.DriverService;
import com.megacitycab.megacitycab.util.ResponseUtil;
import com.megacitycab.megacitycab.util.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverController.class);

    @Autowired
    private DriverService driverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResponseUtil> saveAndUpdateDriver(
            @RequestBody DriverDTO dto
    ) {
        try {
            String msg = (dto.getId() == null || dto.getId()==0) ? "Driver saved successfully." : "Driver updated successfully.";
            return ResponseEntity.ok(new ResponseUtil(HttpStatus.OK, msg, driverService.saveAndUpdateDriver(dto)));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            if (e.getMessage().equals("Diver is not exists!"))
                return ExceptionHandler.handleCustomException(HttpStatus.NOT_FOUND, e);

            return ExceptionHandler.handleException(e);
        }
    }
}
