package com.itechart.carsapi.controller;

import com.itechart.carsapi.exception.InvalidUserDataException;
import com.itechart.carsapi.model.User;
import com.itechart.carsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carsAPI")
public class UserController {
    private final UserService userService;
    @Autowired
    private AmqpTemplate template;

    @PreAuthorize("hasAuthority('users:write')")
    @GetMapping("/users")
    public List<User> getAllCars() {
        return userService.getAllUsers();
    }

    @PreAuthorize("hasAuthority('users:read')")
    @GetMapping("/user")
    public User getUserById(@RequestParam String login, @RequestParam String password) {
        try {
            return userService.getUserByLoginAndPassword(login, password);
        } catch (InvalidUserDataException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage(), e);
        }
    }

    @RequestMapping("/emit")
    public String queue1() {
        System.out.println("Emit to queue1");
        template.convertAndSend("queue1","Message to queue");
        return "Emit to queue";
    }
}
