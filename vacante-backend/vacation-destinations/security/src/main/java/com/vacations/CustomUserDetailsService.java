package com.vacations;

import com.vacations.dao.user.UserEntity;
import com.vacations.dao.user.UserRepository;
import com.vacations.dao.user.pojo.User;
import com.vacations.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CustomUserDetailsService implements UserDetailsService {

	private final UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		Optional<User> userPojo = userService.getByEmailOrFirstName(user,user);
		if(userPojo.isPresent()){
			return new CustomUserDetails(userPojo.get());
		}else
			throw new UsernameNotFoundException("UserName or password is incorect");
	}
}
