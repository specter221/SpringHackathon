package com.stackroute.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springrestapi.domain.UserModel;
import com.stackroute.springrestapi.service.UserService;


@RestController
@RequestMapping("/v0.1/userprofile")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/get" , method=RequestMethod.GET)
	public ResponseEntity  getAllUsers() {
		List <UserModel> user = userservice.getAllUsers();	
		return new ResponseEntity<List<UserModel>>(user,HttpStatus.OK);
				
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json")
	   public ResponseEntity addUser(@RequestBody UserModel usermodel)
	   {
	       /*Add validation code*/        
	       userservice.addUser(usermodel);
	       return new ResponseEntity<String>("List Added", HttpStatus.OK) ;
	   }
	
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	   public ResponseEntity updateUser(@RequestBody UserModel usermodel)
	   {
	       /*Add validation code*/        
	       userservice.updateUser(usermodel);
	       return new ResponseEntity<String>("List Added", HttpStatus.OK) ;
	   }
	
	
	
}
