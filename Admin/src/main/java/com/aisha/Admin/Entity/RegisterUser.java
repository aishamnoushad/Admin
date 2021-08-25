package com.aisha.Admin.Entity;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.aisha.Admin.GenericClasses.ValidEmail;

@Component
public class RegisterUser {
	 @NotNull(message = " is required")
	 @Size(min = 1, message = " is required")
	private String name;
	

	@NotBlank
	@ValidEmail
	@NotNull(message = " is required")
    @Size(min = 1, message = " is required")
	private String email;
	
	@NotBlank
	@NotNull(message = " is required")
    @Size(min = 8, message = " should contain minimum 8 characters")
	private String inputpassword;
	
	
	private String password;
	  
	@Transient
	@NotNull(message = " is required")
	@Size(min = 8, message = " should contain minimum 8 characters")
	private String matchingPassword;
	
	@NotNull(message = " is required")
    @Size(min = 10 , message = " phone number must be in the format 971550000000")
	private String mobileNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInputpassword() {
		return inputpassword;
	}

	public void setInputpassword(String inputpassword) {
		this.inputpassword = inputpassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public RegisterUser(@NotNull(message = " is required") @Size(min = 1, message = " is required") String name,
			@NotBlank @NotNull(message = " is required") @Size(min = 1, message = " is required") String email,
			@NotBlank @NotNull(message = " is required") @Size(min = 8, message = " should contain minimum 8 characters") String inputpassword,
			String password,
			@NotNull(message = " is required") @Size(min = 8, message = " should contain minimum 8 characters") String matchingPassword,
			@NotNull(message = " is required") @Size(min = 10, message = " phone number must be in the format 971550000000") String mobileNumber) {
		super();
		this.name = name;
		this.email = email;
		this.inputpassword = inputpassword;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.mobileNumber = mobileNumber;
	}
	public RegisterUser()
	{
		
	}

	@Override
	public String toString() {
		return "RegisterUser [name=" + name + ", email=" + email + ", inputpassword=" + inputpassword + ", password="
				+ password + ", matchingPassword=" + matchingPassword + ", mobileNumber=" + mobileNumber + "]";
	}
	
}
