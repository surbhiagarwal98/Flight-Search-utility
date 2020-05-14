package com.nagarro.services.api;

import com.nagarro.model.User;

/**
 * this is user service interface it checks login credentials, gets user, and
 * resets password
 * 
 * @author surbhiagarwal
 *
 */
public interface UserService {
	public User getUser(String username);

	public boolean isValidUser(String username, String password);

	public boolean resetPassword(String username, String newPassword);
}
