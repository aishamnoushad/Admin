package com.aisha.Admin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aisha.Admin.Entity.User;
import com.aisha.Admin.Entity.User_Roles;
import com.aisha.Admin.Services.UserRoleService;
import com.aisha.Admin.Services.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
		
	}
	
	@PostMapping("/register")
	@Transactional
	public String processRegistration(@ModelAttribute User user) {
		User newUser = userService.AddUserRequest(user);
		if(newUser!=null)
			userRoleService.saveUserRole(new User_Roles(newUser.getUser_id(),3));
		return "redirect:/login";
	}

}
