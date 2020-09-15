package com.vacations;

import com.vacations.dao.user.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetails implements UserDetails {

	private User user;

	public CustomUserDetails(){}

	public CustomUserDetails(User user){
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getUserRoles()
				.stream()
				.map(role->new SimpleGrantedAuthority("ROLE_"+role.getUserRoleEnum().getLabel()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.getIsAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getIsAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getIsCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.getIsEnabled();
	}
}
