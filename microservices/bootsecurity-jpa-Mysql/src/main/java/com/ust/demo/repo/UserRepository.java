package com.ust.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.demo.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	//we always give findbyid all but we need to findbyname some other function
	//we give here
	Optional<User> findByUserName(String userName);
}
