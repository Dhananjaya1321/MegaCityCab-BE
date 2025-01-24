package com.megacitycab.megacitycab.service.impl;


import com.megacitycab.megacitycab.dto.UserDTO;
import com.megacitycab.megacitycab.enums.UserRoles;
import com.megacitycab.megacitycab.repo.UserRepo;
import com.megacitycab.megacitycab.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO checkLogin(String emailOrUsername, String password) {
        Object[] user = (Object[]) userRepo.searchUserByUsernameOrEmail(emailOrUsername);
        if (user == null)
            throw new RuntimeException("Incorrect email or username");

        String email = String.valueOf(user[0]);
        String username = String.valueOf(user[1]);
        String actualPassword = String.valueOf(user[2]);
        String role = String.valueOf(user[3]);


        UserDTO userDTO = new UserDTO();
        if (actualPassword.equals(password)) {
            userDTO.setEmail(email);
            userDTO.setUsername(username);
            userDTO.setPassword(password);
            userDTO.setRole(UserRoles.valueOf(role));
        } else {
            throw new RuntimeException("Incorrect password");
        }
        return userDTO;
    }
}
