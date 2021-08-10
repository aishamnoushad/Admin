package com.aisha.Admin.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.Admin.Entity.User_Roles;
import com.aisha.Admin.Repository.UserRolesRepository;


@Service
public class UserRoleService {
	@Autowired
	private UserRolesRepository user_RolesRepo;
	
	public User_Roles  saveUserRole(User_Roles user_Roles) {
		return user_RolesRepo.saveAndFlush(user_Roles);
	}
	
	
	public int deleteAllUserRolesOfGivenId(int user_id) {
		return user_RolesRepo.deleteAllUserRolesOfGivenId(user_id);
	}
}
