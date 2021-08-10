package com.aisha.Admin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aisha.Admin.Entity.User;
import com.aisha.Admin.Services.UserRoleService;
import com.aisha.Admin.Services.UserService;



@Controller
public class UserManagementController {
	@Autowired
	private UserService UserService;
	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping("/user_request")
	public String showUserRequestViewPage(Model model) {
		model.addAttribute("userrequest",UserService.getAllUserRequest());
		return "user_request_view";
	}
	
	@GetMapping("/user_request/delete/{user_id}")
	@Transactional
	@Modifying
	public String postdeleteUser(@PathVariable("user_id") int user_id) {
		UserService.deleteUser(user_id);
		userRoleService.deleteAllUserRolesOfGivenId(user_id);
		return "redirect:/user_request";
	}
	
	@GetMapping("/user_request/approve/{user_id}")
	
	public String ApproveUser(@PathVariable("user_id") int user_id, Model model) {
		try {
			User user = new User();
			if(UserService.findByUserId(user_id).isPresent())
				user = UserService.findByUserId(user_id).get();
			UserService.approveRequest(user);
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return "redirect:/user_request";
	}
	@GetMapping("/users/admin")
	public String getAdminList(Model model){
		model.addAttribute("adminList", UserService.gettingAllApprovedAdmins());
		return "Adminlist";
	}
	
	@GetMapping("/admin/delete/{user_id}")
	@Transactional
	@Modifying
	public String postdeleteAdminUser(@PathVariable("user_id") int user_id) {
		UserService.deleteUser(user_id);
		userRoleService.deleteAllUserRolesOfGivenId(user_id);
		return "redirect:/users/admin";
	}
	
}
