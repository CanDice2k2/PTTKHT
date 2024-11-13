package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.exception.UserException;
import com.example.ecommerce.model.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public List<User> findAllUsers();

}
