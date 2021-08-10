package com.aisha.Admin.Controllers;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aisha.Admin.Entity.User;
import com.aisha.Admin.GenericClasses.Utility;
import com.aisha.Admin.Services.UserService;

import net.bytebuddy.utility.RandomString;

@Controller
public class PasswordController {
	@Autowired
    private JavaMailSender mailSender;
	
	 @Autowired
	 private UserService UserService;
	 
	@GetMapping("/forgot")
	public String redirectToPasswordResetPage() {
		return "passwordReset";
	}
	
	@PostMapping("/forgot")
	public String processForgotPassword(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
	    String token = RandomString.make(30);
	     
	    try {
	    	UserService.updateResetPasswordToken(token, email);
	        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
	        sendEmail(email, resetPasswordLink);
	        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
	         
	    } catch (AccountNotFoundException ex) {
	        model.addAttribute("error", ex.getMessage());
	    } catch (UnsupportedEncodingException | MessagingException e) {
	        model.addAttribute("error", "Error while sending email");
	    }
	         
	    return "passwordReset";
	}
	
	public void sendEmail(String recipientEmail, String link)
	        throws MessagingException, UnsupportedEncodingException {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("abcgroupuae2020@gmail.com", "Admin Module Support");
	    helper.setTo(recipientEmail);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	}
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
	    User user = UserService.getByResetPasswordToken(token);
	    model.addAttribute("token", token);
	     
	    if (user == null) {
	        model.addAttribute("message", "Invalid Token");
	        
	    }
	     
	    return "reset_password_form";
	}
	
	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
	    String token = request.getParameter("token");
	    String password = request.getParameter("password");
	     
	    User user = UserService.getByResetPasswordToken(token);
	    model.addAttribute("title", "Reset your password");
	     
	    if (user == null) {
	        model.addAttribute("message", "Invalid Token");
	       // return "message";
	    } else {           
	    	UserService.updatePassword(user, password);
	         
	        model.addAttribute("message", "You have successfully changed your password. Please login");
	    }
	     
	    return "redirect:/login";
	}
	
	@GetMapping("/user_request/reset_password/{user_id}")
	public String showpasswordresetpage(@PathVariable(value="user_id") int UserId, Model model){
		User user = new User();
		if(UserService.findByUserId(UserId).isPresent())
			user = UserService.findByUserId(UserId).get();
		
			if (user == null || user.getUser_id() ==0) {
		        model.addAttribute("message", "No Account Found");
		        return "admin_reset_password";
		    }
			model.addAttribute("user_id", user.getUser_id());
		  return "admin_reset_password";
	}
	
	@PostMapping("/user_request/reset_password/{user_id}")
	public String processResetPasswordByAdmin(HttpServletRequest request, Model model) {
	    int user_id =Integer.parseInt(request.getParameter("user_id"));
	    String password = request.getParameter("password");
	    User user = new User();
	     if(UserService.findByUserId(user_id).isPresent()) {
	    	 user=UserService.findByUserId(user_id).get();
	    	 UserService.updatePassword(user, password);
	    	 model.addAttribute("message", "You have successfully changed password of "+ user.getName());
	     }else {
	    	 model.addAttribute("message", "Invalid Token");
	    	
	     }
	     return "admin_reset_password";
	}
}
