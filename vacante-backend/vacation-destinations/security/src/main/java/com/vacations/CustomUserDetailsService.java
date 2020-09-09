package com.vacations;

import com.vacations.dao.user.UserEntity;
import com.vacations.dao.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		Optional<UserEntity> userDao = userRepository.findByEmailIgnoreCaseOrFirstNameIgnoreCase(user,user);
		if(userDao.isPresent()){
			return new CustomUserDetails(userDao.get());
		}else
			throw new UsernameNotFoundException("UserName or password is incorect");
	}
}
