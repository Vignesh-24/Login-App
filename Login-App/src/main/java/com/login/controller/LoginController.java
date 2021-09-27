package com.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.login.model.User;
import com.login.service.UserService;

@Controller
public class LoginController {
	
	private final UserService userservice;
	
	public LoginController(final UserService userService) {
		this.userservice =userService;
	}
	
	
	
	@GetMapping(value = "")
	public String getLoginPage() {
		return "login";
	}
	
	
	
	@GetMapping(value = "/register")
	public String getRegistration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	
	
	@PostMapping(value = "/register")
	public String registerUser(@ModelAttribute("user") User user, HttpServletRequest request) {
		User registeredUser= userservice.saveUser(user);
		if(registeredUser != null) {
			System.out.println("Registration Completed!!");
			HttpSession session = this.createNewSession(request);
			session.setAttribute("user", registeredUser);
			session.setAttribute("loginFlag", true);
			return "redirect:/app/qrcode";
		}
		return "redirect:/register";
	}
	
	
	
	@PostMapping(value = "/login")
	public String authenticateUser(@RequestParam("username") String username,
			@RequestParam("pass") String password,
			HttpServletRequest request,
			Model model) {
		
		User user= userservice.authenticateUserCredentials(username, password);
		if(user == null) {
			System.out.println("Login Failed!!");
			model.addAttribute("msg", "Invalid Credentials");
			return "login";
		}
			
		//creating new session
		HttpSession session = this.createNewSession(request);
		session.setAttribute("user",user);
		return "redirect:/authotp";
	}
	
	
	
	@GetMapping(value="/logout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		System.out.println("User Logged Out!!!");
		return "redirect:/";
	}
	
	
	
	@GetMapping(value="/sessionerror")
	public String returnSessionErrorPage() {
		return "sessionerror";
	}
	
	
	
	@GetMapping(value="/authotp")
	public String getOtpPage() {
		return "totp";
	}
	
	
	
	@PostMapping(value = "/submitOTP")
	public String validateOtp(@RequestParam("totp") String totp,
			HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession(false);
		if(session == null ) {
			return "redirect:/sessionerror";
		}
		
		User user= (User) session.getAttribute("user");
		if(userservice.verifyOTP(user.getUsername(), totp, user.getSecretkey())) {
			session.setAttribute("loginFlag", true);
			return "redirect:/app/home";
		}
		
		model.addAttribute("msg","Incorrect OTP!!");
		return "totp";
	}
	
	
	
	
	//Function to create a new Session with 5 minutes inactive time
	public HttpSession createNewSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(300);
		return session;
	}
	

}
