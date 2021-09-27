package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.login.service.UserService;

/*
 * This Controller will be used only for authenticated users
 * Requests to this controller will be filtered by using Filter
 */
@Controller
@RequestMapping("/app")
public class UserController {
	
	private final UserService userservice;
	
	public UserController(final UserService userService) {
		this.userservice =userService;
	}
	
	
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	
	
	@GetMapping(value = "/qrcode")
	public String getQRCode() {
		System.out.println("QR Code Registration");
		return "qrcode";
	}
	
	
	
	@GetMapping(value = "/doneregistration/{id}")
	public String postRegistration(@PathVariable("id") String username) {
		userservice.postRegistration(username);
		return "redirect:/app/home";
	}

}
