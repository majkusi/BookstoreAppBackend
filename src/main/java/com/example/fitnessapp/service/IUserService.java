package com.example.fitnessapp.service;

import com.example.fitnessapp.modelDto.UserDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IUserService {

    UserDto userRegister(UserDto userDto) throws IOException;
}
