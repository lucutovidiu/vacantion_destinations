package com.vacations.user;

import com.vacations.dao.user.UserEntity;
import com.vacations.dao.user.UserRepository;
import com.vacations.dao.user.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public Optional<User> getByEmailOrFirstName(String email, String firstName) {
        return userRepository.findByEmailIgnoreCaseOrFirstNameIgnoreCase(email, firstName)
                .map(UserEntity::toUser);
    }
}
