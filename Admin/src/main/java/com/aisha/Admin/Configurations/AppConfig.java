package com.aisha.Admin.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aisha.Admin.Entity.User;
import com.aisha.Admin.Handlers.MyAuthenticationFailureHandler;
import com.aisha.Admin.Services.AdminUserDetailService;



@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Bean
    public UserDetailsService userDetailsService() {
        return new AdminUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public User user() {
        return new User();
    }
    @Bean
    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return new MyAuthenticationFailureHandler();
    }
//    @Bean
//    public ActiveUserStore activeUserStore(){
//        return new ActiveUserStore();
//    }
   
}
