package com.vacations.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserDao,Integer> {

	Optional<UserDao> findByEmail(String email);

	Optional<UserDao> findByEmailIgnoreCaseOrFirstNameIgnoreCase(String email, String firstName);

}
