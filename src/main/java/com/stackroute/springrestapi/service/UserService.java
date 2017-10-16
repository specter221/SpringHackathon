package com.stackroute.springrestapi.service;

import java.util.List;


import com.stackroute.springrestapi.domain.UserModel;

public interface UserService {
	public List<UserModel> getAllUsers( ); //Retrieve all user profiles
	public UserModel addUser(UserModel usermodel); //Add a new user profile
	public UserModel updateUser(UserModel usermodel); //Update a user profile 
	public int getUserbyId(int id); //Retrieve a user profile by ID 
    public boolean delete(int id); //Delete a user profile
	

}
