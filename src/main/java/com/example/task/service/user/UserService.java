package com.example.task.service.user;

import com.example.task.dto.UserDto;
import com.example.task.entity.User;
import com.example.task.exception.UserNotFoundException;
import com.example.task.repository.UserRepository;
import com.example.task.service.log.LoggingService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private LoggingService loggingService;

    public UserService(UserRepository userRepository, LoggingService loggingService) {
        this.userRepository = userRepository;
        this.loggingService = loggingService;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " not found"));
        loggingService.logData(user.toString());
        return new UserDto(user.getId(), user.getName());
    }

    public void addUser(UserDto userDto) {
        User user = new User(userDto.getId(), userDto.getName());
        userRepository.save(user);
    }
}
