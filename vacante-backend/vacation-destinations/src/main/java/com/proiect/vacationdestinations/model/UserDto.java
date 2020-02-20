package com.proiect.vacationdestinations.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private String email;

	private String firstName;

	private String lastName;

	private String gender;

	private String password;

	private List<String> userRoles;
}
