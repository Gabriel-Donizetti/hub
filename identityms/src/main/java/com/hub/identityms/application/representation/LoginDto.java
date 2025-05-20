package com.hub.identityms.application.representation;

import com.hub.identityms.domain.EmailType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDto(

        @NotBlank
        @NotNull
        EmailType email,

        @NotBlank
        @NotNull
        String password
) {
}
