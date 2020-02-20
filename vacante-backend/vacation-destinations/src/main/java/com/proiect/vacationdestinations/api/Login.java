package com.proiect.vacationdestinations.api;

import com.proiect.vacationdestinations.dao.UserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/")
public interface Login {

	@GetMapping()
	String logMeIn();

	@GetMapping("/users")
	Optional<UserDao> getUsers();

}
