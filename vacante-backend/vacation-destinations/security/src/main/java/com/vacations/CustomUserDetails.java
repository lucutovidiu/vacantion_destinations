package com.vacations;

import com.vacations.dao.user.UserDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetails implements UserDetails {

	UserDao userDao;

	public CustomUserDetails(){}

	public CustomUserDetails(UserDao userDao){
		this.userDao = userDao;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.userDao.getUserRoles()
				.stream()
				.map(role->new SimpleGrantedAuthority("ROLE_"+role.getUserRoleEnum().getLabel()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return userDao.getPassword();
	}

	@Override
	public String getUsername() {
		return userDao.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return userDao.getIsAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return userDao.getIsAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return userDao.getIsCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return userDao.getIsEnabled();
	}
}
