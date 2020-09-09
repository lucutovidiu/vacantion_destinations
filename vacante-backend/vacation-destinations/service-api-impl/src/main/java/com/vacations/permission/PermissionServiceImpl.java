package com.vacations.permission;

import com.vacations.dao.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PermissionServiceImpl implements PermissionService {

    private UserRepository userRepository;

    @Override
    public PermissionDto getUserPermissions() {
        return userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .map(userDao -> new PermissionDto(userDao.getEmail(),
                        userDao.getUserRoles().stream().map(role -> role.getUserRoleEnum().toString()).collect(Collectors.toList())))
                .orElse(new PermissionDto());
    }
}
