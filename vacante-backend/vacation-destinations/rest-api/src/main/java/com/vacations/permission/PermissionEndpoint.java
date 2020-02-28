package com.vacations.permission;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permission")
public interface PermissionEndpoint {

	@GetMapping
	@PreAuthorize("hasAnyRole('USER')")
	PermissionDto getUserPermissions();

}
