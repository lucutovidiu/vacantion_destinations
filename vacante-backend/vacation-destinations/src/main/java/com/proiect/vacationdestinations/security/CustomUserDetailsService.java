package com.proiect.vacationdestinations.security;

import com.proiect.vacationdestinations.dao.UserDao;
import com.proiect.vacationdestinations.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		Optional<UserDao> userDao = userRepo.findByEmailIgnoreCaseOrFirstNameIgnoreCase(user,user);
		if(userDao.isPresent()){
			return new CustomUserDetails(userDao.get());
		}else
			throw new UsernameNotFoundException("UserName or password is incorect");
	}
}
