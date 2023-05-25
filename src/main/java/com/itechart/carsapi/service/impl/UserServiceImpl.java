package com.itechart.carsapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.carsapi.exception.InvalidUserDataException;
import com.itechart.carsapi.exception.UserNotExistException;
import com.itechart.carsapi.model.SecurityUser;
import com.itechart.carsapi.model.User;
import com.itechart.carsapi.repository.UserRepository;
import com.itechart.carsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userDetailService")
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) throws UserNotExistException, InvalidUserDataException {
        try {
            Optional<User> user = getUser(login);
            if (!user.isPresent()) {
                throw new UserNotExistException("No such User with login: " + login);
            }
            if (!passwordEncoder.matches(password, user.get().getPassword())) {
                throw new InvalidUserDataException("Password \"" + password + "\" is not correct for User with login: " + login);
            }
            return user.get();
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            User user = getUser(login).orElseThrow(() ->
                    new UsernameNotFoundException("User doesn't exists"));
            return SecurityUser.fromUser(user);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: " + e.getLocalizedMessage());
            return null;
        }
    }

    public Optional<User> getUser(String login) throws JsonProcessingException {
        String userData = (String) rabbitTemplate.convertSendAndReceive("user.exchange", "get.user", login);
        if (userData == null) {
            return Optional.empty();
        }
        User user = objectMapper.readValue(userData, User.class);
        return Optional.of(user);
    }
}
