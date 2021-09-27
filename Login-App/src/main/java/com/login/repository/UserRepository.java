package com.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.login.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByUsername(String username);

}
