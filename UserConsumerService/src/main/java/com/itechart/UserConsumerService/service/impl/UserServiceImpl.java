package com.itechart.UserConsumerService.service.impl;

import com.itechart.UserConsumerService.model.User;
import com.itechart.UserConsumerService.repository.UserRepository;
import com.itechart.UserConsumerService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
