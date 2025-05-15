package com.hub.identityms.application;

import com.hub.identityms.application.representation.LoginDto;
import com.hub.identityms.application.representation.RegisterDto;
import com.hub.identityms.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity login(LoginDto req) {
    }

    public ResponseEntity register(RegisterDto req) {
    }

    public ResponseEntity getUser(String id) {
    }
}
