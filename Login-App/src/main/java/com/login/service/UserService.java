package com.login.service;

import com.login.model.User;

public interface UserService {

	/**
	 * This Method takes the user object and saves it to the database.
	 * @param user - Details of user
	 * @return Saved User Object
	 */
	public User saveUser(User user);
	
	/**
	 * 
	 * @param username - user name for which user to be validated
	 * @param password - entered password by the user
	 * @return User associated with the user name if authentication is success
	 */
	public User authenticateUserCredentials(String username, String password);
	
	/**
	 * To carry out post registration process (deleting QR code image)
	 * @param username - registered user name
	 */
	public void postRegistration(String username);
	
	/**
	 * 
	 * @param username - current user
	 * @param otp - otp entered by user
	 * @param secretkey - user's secret key
	 * @return true if authentication is successful 
	 */
	public Boolean verifyOTP(String username, String otp, String secretkey);
		
}
