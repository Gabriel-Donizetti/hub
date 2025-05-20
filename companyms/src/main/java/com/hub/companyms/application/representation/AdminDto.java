package com.hub.companyms.application.representation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdminDto(

        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank String identifier,

        @NotNull
        @NotBlank String segment,

        @NotNull
        @NotBlank String email,

        @NotNull
        @NotBlank String password

) {
        //TODO: fazer o metodo toEntity
}
