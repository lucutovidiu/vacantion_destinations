package com.vacations.permission;

import org.springframework.stereotype.Service;

@Service
public interface PermissionService {

    PermissionDto getUserPermissions();
}
