package com.hub.companyms.application.representation;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record SegmentDto(

        @NotNull(message = "Invalid name")
        @NotBlank(message = "Invalid name")
        @Size(min = 2, message = "The field must be at least 2 characteres")
        String name
) {
    //TODO: fazer o metodo toEntity
}