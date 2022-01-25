package com.dbal.app.users.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/userPage")
	public String userPage() {
		return "users/users";
	}
	
	
	@GetMapping("/loginForm")
	public String String() {
		return "insa/login";
	}
}
