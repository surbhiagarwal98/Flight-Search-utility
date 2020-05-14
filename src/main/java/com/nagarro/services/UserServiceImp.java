package com.nagarro.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.api.UserDao;
import com.nagarro.model.User;
import com.nagarro.services.api.UserService;

/**
 * 
 * @author surbhiagarwal
 *
 */
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUser(String username) {
		return userDao.getUser(username);
	}

	public boolean isValidUser(String username, String password) {

		boolean isUser = userDao.isUser(username, password);
		if (isUser) {
			return true;
		}
		return false;
	}

	public boolean resetPassword(String username, String newPassword) {

		boolean isSuccessfulReset = userDao.resetPassword(username, newPassword);
		if (isSuccessfulReset) {
			System.out.println("Password reset successful!");
			return true;
		} else {
			System.out.println("Could not reset,an error occured.");
		}
		return false;

	}

}
