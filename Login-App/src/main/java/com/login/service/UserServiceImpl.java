package com.login.service;


import org.springframework.stereotype.Service;
import com.login.model.User;
import com.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	private final AuthenticationService authService;
	
	//Constructor based dependency injection
	public UserServiceImpl(final UserRepository userRepository, final AuthenticationService authService) {
		this.userRepository = userRepository;
		this.authService = authService;
	}

	
	
	//Method to find user by name
	//It acts as a utility for save and authentication 
	private User findUser(String username) {
		User user= userRepository.findByUsername(username);
		return user;
	}

	
	
	@Override
	public User saveUser(User user) {
		//checking for existing user
		if( null != findUser(user.getUsername())) {
			System.out.println("User with username already exists!!");
			return null;
		}
		
		//assigning secret key
		String secretKey = authService.generateSecretKey();
		user.setSecretkey(secretKey);
		String path = authService.createQRCode(user.getSecretkey(), user.getUsername());
		System.out.println("Path: "+path);
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	
	
	@Override
	public User authenticateUserCredentials(String username, String password) {
		User user=findUser(username);
		if ( user != null) {
			if( user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}



	@Override
	public void postRegistration(String username) {
		authService.deleteQRCode(username);
	}



	@Override
	public Boolean verifyOTP(String username, String otp, String secretkey) {
		return authService.authenticateTOTPCode(otp, secretkey);
	}

	

	
}
