package com.hub.identityms.application.representation;

import com.hub.identityms.domain.EmailType;
import com.hub.identityms.domain.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDto(

        @NotBlank
        @NotNull
        String name,

        @NotBlank
        @NotNull
        String identifier,

        @NotBlank
        @NotNull
        EmailType email,

        @NotBlank
        @NotNull
        String password,

        @NotBlank
        @NotNull
        UserRole role

) {
    //TODO: fazer metodo toEntity
}
