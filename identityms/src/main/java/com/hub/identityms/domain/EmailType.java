package com.hub.identityms.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class EmailType {

    private final String email;
    private final String domain;

    public EmailType(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        this.email = email.trim().toLowerCase();
        String[] partes = this.email.split("@");
        this.domain = partes[1];
    }

    public boolean belongToDomain(String domain) {
        return this.domain.equalsIgnoreCase(domain);
    }
}
