package com.aisha.Admin.Controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
		
	}
	
	@PostMapping("/register")
	@Transactional
	public String processRegistration( @ModelAttribute  @Valid User user ,BindingResult theBindingResult,
            Model theModel) {
		String username = user.getName();
		log.info("Processing registration form for: " + username);
		if (theBindingResult.hasErrors()) {
            return "register";
        }
		log.info("After error checking" + theBindingResult);
		User existingUser = userService.FindByEmail(user.getEmail());
        if (existingUser != null) {
            theModel.addAttribute("user", new User());
            theModel.addAttribute("registrationError", "User already exist in database");

            log.warn("User name already exists.");
            return "register";
        }
		User newUser = userService.AddUserRequest(user);
		if(newUser!=null)
			userRoleService.saveUserRole(new User_Roles(newUser.getUser_id(),3));
		log.info("Successfully created user: " + username);
		return "redirect:/login";
	}

}
