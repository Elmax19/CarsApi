package com.itechart.UserConsumerService.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.UserConsumerService.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.itechart.UserConsumerService.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserMessageListener {
    private final UserRepository userRepository;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "myQueue", durable = "true"),
            exchange = @Exchange(value = "user.exchange", type = "topic", durable = "true"),
            key = "get.user"))
    public String handleGetUserMessage(String login) throws JsonProcessingException {
        Optional<User> user = userRepository.findByLogin(login);
        if (user.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(user.get());
        }
        return null;
    }
}
