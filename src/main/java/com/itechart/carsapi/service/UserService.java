package com.itechart.carsapi.service;

import com.itechart.carsapi.exception.InvalidUserDataException;
import com.itechart.carsapi.exception.UserNotExistException;
import com.itechart.carsapi.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User getUserByLoginAndPassword(String login, String password) throws UserNotExistException, InvalidUserDataException;
}
