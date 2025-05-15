package com.hub.identityms.application.representation;

import com.hub.identityms.domain.EmailType;
import com.hub.identityms.domain.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

    private String name;
    private String identifier;
    private EmailType email;
    private String password;
    private UserRole role;

}
