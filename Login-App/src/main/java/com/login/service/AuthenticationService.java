package com.login.service;


public interface AuthenticationService {
	
	/**
	 * This method is used to generate secret key for new user
	 * 
	 * @return secret key which is generated
	 */
	public String generateSecretKey();
	
	/**
	 * method to validate user OTP with the system generated OTP 
	 * 
	 * @param userOtp - OTP entered by User 
	 * @param secretkey - key for which validation to be carried out
	 * @return true if validation is succeeded
	 */
	public Boolean authenticateTOTPCode(String userOtp, String secretkey);
	
	/**
	 * To create new QR code for User Registration
	 * 
	 * @param secretkey
	 * @param username
	 * @return image name
	 */
	public String createQRCode(String secretkey, String username);
	
	/**
	 * Method to delete QR code image as it is no longer needed once user scans it with Authenticator
	 * 
	 * @param username - whose QR code to be deleted
	 */
	public void deleteQRCode(String username);

}
