package com.stackroute.springrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.springrestapi.domain.UserModel;
import com.stackroute.springrestapi.exceptions.NotValidException;
import com.stackroute.springrestapi.exceptions.UserAlreadyExists;
import com.stackroute.springrestapi.service.UserService;


@RestController
@RequestMapping("/v0.1/userprofile")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	/*Get all User */
	@RequestMapping(value="/get" , method=RequestMethod.GET)
	public ResponseEntity  getAllUsers() {
		List <UserModel> user = userservice.getAllUsers();	
		
		if(user==null)
		{
		return new ResponseEntity<List<UserModel>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserModel>>(user,HttpStatus.OK);
}
	
	/*add user in the database */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json")
	   public ResponseEntity addUser( @RequestBody UserModel usermodel) throws NotValidException
	   {
	       /*Add validation code*/
	if(!(usermodel.getEmail_id().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")))
	     throw new NotValidException("Invalid email");
	else if(!(usermodel.getUsername().matches("^[A-Za-z0-9_]")))
			throw new NotValidException("Username cannot be empty");
	       userservice.addUser(usermodel);
	       return new ResponseEntity<String>("User Added", HttpStatus.OK) ;
	   }
	
	
	/*update user in the database */
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	   public ResponseEntity updateUser(@RequestBody UserModel usermodel) throws UserAlreadyExists
	   {
	       /*Add validation code*/ 
			UserModel usermodel1= userservice.updateUser(usermodel);
			if(usermodel==usermodel1) throw new UserAlreadyExists("user already exists");
		

		else {
	       return new ResponseEntity<String>("user updated", HttpStatus.OK) ;
	   }
	   }

	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}", consumes="application/json")
    public ResponseEntity<String> delete(@PathVariable(value="id") int id){
    
        /*Add validation code*/        
	  userservice.delete(id);
      return new ResponseEntity<String>("Deleted succesfully", HttpStatus.OK) ;
        
    }
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	   public ResponseEntity <UserModel> getById(@PathVariable("id") int id) {
	     
	     UserModel usermodel=userservice.getUserbyId(id);
	       if (usermodel == null) {
	           return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
	       }
	           return new ResponseEntity<UserModel>(usermodel,HttpStatus.OK);
	   }
	
	
}
