package com.hub.identityms.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UserRole {
    ADMIN("admin"),
    EMPLOYE("employe");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }

    public static UserRole fromString(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.role.equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid role: " + role));
    }
}
