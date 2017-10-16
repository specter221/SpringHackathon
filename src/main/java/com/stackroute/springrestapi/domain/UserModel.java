package com.stackroute.springrestapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {
	@Id
	private int id;
	private String username;
	private String email_id;
	public int getId() {
		return id;
	}
	
	//getters and setters
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	//constructor
	public UserModel(int id, String username, String email_id) {
		super();
		this.id = id;
		this.username = username;
		this.email_id = email_id;
	}
	public UserModel() { 

}
}
