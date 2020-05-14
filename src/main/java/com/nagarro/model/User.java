package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * this is entity class
 * 
 * @author surbhiagarwal
 *
 */
@Entity
@Table(name = "userdetails")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;

	public User() {

	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
