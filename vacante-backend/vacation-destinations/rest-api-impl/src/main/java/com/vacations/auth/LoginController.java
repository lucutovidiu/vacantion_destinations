package com.vacations.auth;

import org.springframework.stereotype.Component;

@Component
public class LoginController implements LoginEndpoint {

    @Override
    public LoginResponse getAuthenticated() {
        return new LoginResponse("Authenticated");
    }
}
