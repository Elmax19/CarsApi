package com.itechart.UserConsumerService.event;

public class UserEvent {
    private final String message;

    public UserEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
