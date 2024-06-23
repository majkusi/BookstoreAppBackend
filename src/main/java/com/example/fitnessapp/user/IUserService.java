package com.example.fitnessapp.user;

import com.example.fitnessapp.modelDto.UserDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public interface IUserService {

    UserDto userRegister(UserDto userDto) throws IOException;

    Optional<User> getUserByEmail(String email) throws IOException;
}
