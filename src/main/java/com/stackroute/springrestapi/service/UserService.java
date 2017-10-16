package com.stackroute.springrestapi.service;

import java.util.List;


import com.stackroute.springrestapi.domain.UserModel;



public interface UserService {
	public List<UserModel> getAllUsers( );
	public UserModel addUser(UserModel usermodel);
	public UserModel updateUser(UserModel usermodel);
	public int getUserbyId(int id);
    public boolean delete(int id);
	

}
