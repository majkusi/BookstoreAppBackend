package com.example.fitnessapp.user;

import com.example.fitnessapp.modelDto.UserDto;
import com.example.fitnessapp.validation.PasswordValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public UserDto registerUser(UserDto userDto) throws IOException {
        if (!PasswordValidator.validatePassword(userDto.getPassword())) {
            throw new RuntimeException("bad password");
        }
        if (userRepository.existsUserModelByUsername(userDto.getUsername()) || userRepository.existsUserModelByEmail(userDto.getEmail())) {
            throw new IOException("Username or email taken");
        }
        User user = saveUser(userDto);
        return modelMapper.map(user, UserDto.class);
    }

    private User saveUser(UserDto userDto) throws IOException {
        User newUser = new User();
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());
        return userRepository.save(newUser);
    }


}
