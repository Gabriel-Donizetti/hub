package com.hub.identityms.application;

import com.hub.identityms.application.representation.LoginDto;
import com.hub.identityms.application.representation.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto req){
        return service.register(req);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto req){
        return service.login(req);
    }

    @GetMapping(params = "identifier")
    public ResponseEntity getUser(@RequestParam("identifier") String id){
        return service.getUser(id);
    }
}
