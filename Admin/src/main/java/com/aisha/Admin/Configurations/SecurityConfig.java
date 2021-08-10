package com.aisha.Admin.Configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.aisha.Admin.Handlers.AdminAuthenticationSuccessHandler;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	 AuthenticationFailureHandler  MyAuthenticationFailureHandler;
	@Autowired
	AdminAuthenticationSuccessHandler adminAuthenticationSuccessHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
    	try {
			auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		///authorisation
		  http.authorizeRequests()
//          .antMatchers("/").hasAnyAuthority("REQUESTER", "ADMIN", "ADMIN_MANAGER")
          .antMatchers("/admin","/category","/subcategory","/subsubcategory","/products").hasAnyAuthority("REQUESTER", "ADMIN", "ADMIN_MANAGER")
          .antMatchers("/category/edit/**","/subcategory/edit/**","/subsubcategory/edit/**","/products/edit/**").hasAnyAuthority("ADMIN", "ADMIN_MANAGER")
          .antMatchers("/category/update/**","/subcategory/update/**","/subsubcategory/update/**","/products/update/**").hasAnyAuthority("ADMIN","ADMIN_MANAGER")
          .antMatchers("/category/delete/**","/subcategory/delete/**","/subsubcategory/delete/**","/products/delete/**").hasAnyAuthority("ADMIN","ADMIN_MANAGER")
          .antMatchers("/category/add/**","/subcategory/add/**","/subsubcategory/add/**","/products/add/**").hasAnyAuthority("ADMIN","ADMIN_MANAGER")
          .antMatchers("/login", "/resource/**","/register","/postLogin","/forgot","/reset_password").permitAll()
          .antMatchers("/js/**", "/css/**").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin().loginPage("/login").permitAll()
          .and()
          .logout().permitAll()
          .and()
          .exceptionHandling().accessDeniedPage("/unauthorized").and().csrf().disable();
//          ;
		// TODO Auto-generated method stub
//		http
//        .authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN", "ADMIN_MANAGER")
//        .and()
//        .authorizeRequests().antMatchers("/login", "/resource/**").permitAll()
//        .and()
//        .formLogin()
//        .successHandler(adminAuthenticationSuccessHandler)
//        .failureHandler(MyAuthenticationFailureHandler)
//        .loginPage("/login")
//        .defaultSuccessUrl("/dashboard")
//        .and().csrf().disable();
//        .usernameParameter("username").passwordParameter("password").permitAll()
//        .loginProcessingUrl("/login")
//        .successForwardUrl("/dashboard")
//        .failureUrl("/login?error")
//        .failureHandler(null);
		
//        .and()
//        .logout().logoutSuccessUrl("/logout").permitAll()
//        .and()
//        .csrf().disable();
		
	}
}
