package com.itechart.carsapi.model;

public enum Permission {
    USERS_WRITE("users:write"),
    USERS_READ("users:read"),
    CARS_WRITE("cars:write"),
    CARS_READ("cars:read"),
    GARAGE_WRITE("garage:write"),
    GARAGE_READ("garage:read");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
