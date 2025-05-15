package com.hub.identityms.application.representation;

import com.hub.identityms.domain.EmailType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private EmailType email;
    private String password;
}
