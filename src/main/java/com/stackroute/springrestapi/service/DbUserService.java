package com.stackroute.springrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stackroute.springrestapi.domain.UserModel;
import com.stackroute.springrestapi.repository.UserRepository;


@Service
public class DbUserService implements UserService {

	@Autowired
	UserRepository userRepository;
	
	/*Retrieve all user profiles*/
	@Override
	public List<UserModel> getAllUsers() {
		return (List)userRepository.findAll();
	}

	/*Add a new user profile*/
	@Override
	public UserModel addUser(UserModel usermodel) {
		userRepository.save(usermodel);
	      return usermodel;
	}

	/*Update a user profile*/
	@Override
	public UserModel updateUser(UserModel usermodel) {
		userRepository.save(usermodel);
		return usermodel;
	}

	/*Retrieve a user profile by ID*/
	@Override
	public int getUserbyId(int id) {
		userRepository.findOne(id);
		return id;
	}

	/*Delete a user profile*/
	@Override
	public boolean delete(int id) {
		userRepository.delete(id);
		   //System.out.println("delete is running..");
		   return true;
	}
	

}
