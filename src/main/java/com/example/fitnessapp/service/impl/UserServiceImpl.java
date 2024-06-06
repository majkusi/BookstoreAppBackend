package com.example.fitnessapp.service.impl;

import com.example.fitnessapp.model.UserModel;
import com.example.fitnessapp.modelDto.UserDto;
import com.example.fitnessapp.repository.IUserRepository;
import com.example.fitnessapp.validation.PasswordValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl {

    private final IUserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public UserDto registerUser(UserDto userDto) throws IOException {
        if (!PasswordValidator.validatePassword(userDto.getPassword())) {
            throw new RuntimeException("bad password");
        }
        if (userRepository.existsUserModelByUserName(userDto.getUsername()) || userRepository.existsUserModelByEmail(userDto.getEmail())) {
            throw new IOException("Username or email taken");
        }
        UserModel user = saveUser(userDto);
        return modelMapper.map(user, UserDto.class);
    }

    private UserModel saveUser(UserDto userDto) throws IOException {
        UserModel newUser = new UserModel();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());
        return userRepository.save(newUser);
    }


}
