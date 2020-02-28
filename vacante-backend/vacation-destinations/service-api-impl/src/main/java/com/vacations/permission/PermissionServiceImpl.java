package com.vacations.permission;

import com.vacations.dao.permission.UserRolesDao;
import com.vacations.dao.permission.UserRolesRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class PermissionServiceImpl implements PermissionService {

    private UserRolesRepo userRolesRepo;

    @Override
    public PermissionDto getUserPermissions() {
        return convertToPermissionDto(userRolesRepo.findAll());
    }

    private PermissionDto convertToPermissionDto(List<UserRolesDao> userRolesDao){
        if(!userRolesDao.isEmpty())
            return new PermissionDto(userRolesDao.get(0).getUserId().getEmail(),
                    userRolesDao.stream().map(userRolesDao1 -> userRolesDao1.getUserRoleEnum().toString()).collect(Collectors.toList()));
        else
            return new PermissionDto();

    }
}
