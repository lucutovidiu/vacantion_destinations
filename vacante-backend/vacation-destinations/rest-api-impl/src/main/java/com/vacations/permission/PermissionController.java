package com.vacations.permission;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PermissionController implements PermissionEndpoint {

    private PermissionService permissionService;

    @Override
    public PermissionDto getUserPermissions() {
        return permissionService.getUserPermissions();
    }
}
