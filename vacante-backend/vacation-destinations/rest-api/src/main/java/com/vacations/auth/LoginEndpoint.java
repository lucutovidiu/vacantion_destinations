package com.vacations.auth;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public interface LoginEndpoint {

    @GetMapping("/login")
    @PostAuthorize("hasAnyRole('USER')")
    LoginResponse getAuthenticated();
}
