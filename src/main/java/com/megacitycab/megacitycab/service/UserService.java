package com.megacitycab.megacitycab.service;


import com.megacitycab.megacitycab.dto.UserDTO;

public interface UserService {
    UserDTO checkLogin(String emailOrUsername, String password);

}
