package com.proiect.vacationdestinations.app;

import com.proiect.vacationdestinations.api.Login;
import com.proiect.vacationdestinations.dao.UserDao;
import com.proiect.vacationdestinations.dao.UserRolesDao;
import com.proiect.vacationdestinations.model.Role;
import com.proiect.vacationdestinations.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class LoginController implements Login {

	@Autowired
	UserRepo userRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public String logMeIn() {
		UserDao user = new UserDao();
		user.setEmail("ovi@email.com");
		user.setFirstName("ovi");
		user.setLastName("Lucut");
		user.setGender("male");

		user.setPassword(bCryptPasswordEncoder.encode("ovi"));
		UserRolesDao userRoles = new UserRolesDao();
		userRoles.setUserRole(Role.ADMIN);
		userRoles.setUserId(user);
		user.setUserRoles(Arrays.asList(userRoles));
		userRepo.save(user);

		return "logged in";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@Override
	public Optional<UserDao> getUsers() {
		return userRepo.findByEmailIgnoreCaseOrFirstNameIgnoreCase("","Ovi");
	}
}
