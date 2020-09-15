package com.vacations.user;

import com.vacations.dao.user.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User> getByEmailOrFirstName(String email, String firstName);
}
