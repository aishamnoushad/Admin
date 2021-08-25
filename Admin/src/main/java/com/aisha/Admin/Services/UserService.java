package com.aisha.Admin.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aisha.Admin.Entity.User;
import com.aisha.Admin.Entity.User_Roles;
import com.aisha.Admin.Repository.UserRepository;
import com.aisha.Admin.Repository.UserRolesRepository;



@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRolesRepository UserRolesRepository;
	@Transactional
	public User AddUserRequest(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getInputpassword());
	    user.setPassword(encodedPassword);
	    user.setStatus(5);
	    user.setRole(3);
	    user.setCreated_at(LocalDateTime.now());
	    user.setUpdated_at(LocalDateTime.now());
		return userRepository.saveAndFlush(user);
	}
	
	public List<User> getAllUserRequest(){
		return userRepository.findAll().stream().filter(t->t.getStatus()==5).collect(Collectors.toList());
		
	}
	
	public void updateResetPasswordToken(String token, String email) throws AccountNotFoundException {
		User user = userRepository.findByEmail(email);
        if (user != null) {
        	user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new AccountNotFoundException("Could not find any customer with the email " + email);
        }
    }
     
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
    
    public User deleteUser(int user_id) {
    	return userRepository.deleteById(user_id);
    }
    
    public Optional<User> findByUserId(int user_id) {
    	return userRepository.findById(user_id);
    }
    @Transactional
    @Modifying
    public void approveRequest(User user) {
        user.setStatus(2);
        user.setApproved_date(LocalDateTime.now());
        int done =UserRolesRepository.deleteRequestorRoleOnceApproved(user.getUser_id());
        System.out.println(done);
        User_Roles userRole = new User_Roles();
        userRole.setUser_id(user.getUser_id());
        userRole.setRole_id(2);
        User_Roles User_Roles = UserRolesRepository.save(userRole);
        System.out.println(User_Roles);
        userRepository.save(user);
    }
    public List<User> gettingAllApprovedAdmins(){
    	return userRepository.findAllBystatus(2);
    }
    
    public User FindByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
}
