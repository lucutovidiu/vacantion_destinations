package com.vacations.permission;

import com.vacations.dao.permission.RoleEnum;
import com.vacations.dao.permission.UserRolesDao;
import com.vacations.dao.user.UserDao;
import com.vacations.dao.user.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PermissionServiceImpl implements PermissionService {

    private UserRepo userRepo;

    @Override
    public PermissionDto getUserPermissions() {
        return userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .map(userDao -> new PermissionDto(userDao.getEmail(),
                        userDao.getUserRoles().stream().map(role -> role.getUserRoleEnum().toString()).collect(Collectors.toList())))
                .orElse(new PermissionDto());
    }
}
