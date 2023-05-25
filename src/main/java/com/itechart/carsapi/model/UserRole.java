package com.itechart.carsapi.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    ROLE_ADMIN(Set.of(
            Permission.USERS_READ,
            Permission.USERS_WRITE,
            Permission.CARS_READ,
            Permission.CARS_WRITE,
            Permission.GARAGE_READ,
            Permission.GARAGE_WRITE)),
    ROLE_USER(Set.of(
            Permission.USERS_READ,
            Permission.CARS_READ,
            Permission.GARAGE_READ));

    private final Set<Permission> permissions;

    UserRole(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream().map(
                permission -> new SimpleGrantedAuthority(permission.getPermission())
        ).collect(Collectors.toSet());
    }
}
