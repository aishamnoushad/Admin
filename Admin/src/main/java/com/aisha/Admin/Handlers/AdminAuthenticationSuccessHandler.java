package com.aisha.Admin.Handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.aisha.Admin.Entity.User;
import com.aisha.Admin.GenericClasses.MyUserPrincipal;
@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	@Autowired
	//private ActiveUserStore activeUserStore;
	 private static final Logger log = LoggerFactory.getLogger(AdminAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		
//		 UsernamePasswordAuthenticationToken authReq
//	      = new UsernamePasswordAuthenticationToken(loggingUser.getEmail(), loggingUser.getPassword());
//	    Authentication authentication = authManager.authenticate(authReq);
	    
	    SecurityContext sc = SecurityContextHolder.getContext();
	    sc.setAuthentication(authentication);
	   // HttpSession session = req.getSession(true);
		
		validatePrinciple(authentication.getPrincipal());
		User loggedInUser = ((MyUserPrincipal) authentication.getPrincipal()).getUser();
		log.info("postLogin()" + loggedInUser.getUser_id());
		log.info("postLogin()" + loggedInUser.getRoles());
		//model.addAttribute("currentUserId", loggedInUser.getUser_id());
		log.info("postLogin()" + loggedInUser.getName());
		//model.addAttribute("currentUser", loggedInUser.getName());
		log.info("postLogin()" + loggedInUser.getUser_id());
		session.setAttribute("userId", loggedInUser.getUser_id());
		session.setAttribute("userName", loggedInUser.getName());
		session.setAttribute("ActiveUser", loggedInUser);
		
	}
	private void validatePrinciple(Object principal) {
		if (!(principal instanceof MyUserPrincipal)) {
			throw new  IllegalArgumentException("Principal can not be null!");
		}
	}
}
