package com.itechart.UserConsumerService.controller;

import com.itechart.UserConsumerService.event.UserEvent;
import com.itechart.UserConsumerService.model.User;
import com.itechart.UserConsumerService.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/userAPI")
@Slf4j
public class UserController {
    private final ApplicationEventPublisher eventPublisher;
    private final UserService userService;

    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers() {
        List<User> users = userService.getAll();
        UserEvent event = new UserEvent("getAllUsers returned: " + users.toString());
        eventPublisher.publishEvent(event);
        return users;
    }

    @EventListener
    public void handleMyEvent(UserEvent event) {
        log.info(event.getMessage());
    }
}
