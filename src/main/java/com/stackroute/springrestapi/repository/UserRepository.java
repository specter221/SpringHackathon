package com.stackroute.springrestapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.springrestapi.domain.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>{
	

}
