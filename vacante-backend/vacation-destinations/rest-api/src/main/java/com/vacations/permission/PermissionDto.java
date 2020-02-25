package com.vacations.permission;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PermissionDto {
	private String user;
	private List<String> permissions;
}
