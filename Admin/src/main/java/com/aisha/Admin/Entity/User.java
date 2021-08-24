package com.aisha.Admin.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityReference(alwaysAsId=true)
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 5381833182834534405L;
	@Transient
	@Autowired(required=false)
	public StatusUpdates statusdescription;
	public User() {

	}
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	@Column(name = "status")
	private int status;
	private String name;
	
	@UniqueElements
	@NotBlank
	@NotNull
	private String email;
	
	private Date email_verified_at;
	@NotBlank
	@NotNull
	private String password;
	@Transient
	private int role;
	@Transient
	private String roleName;
	private String remember_token;
	private String mobileNumber;
	private String profile_photo_path;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private LocalDateTime approved_date;
	@Transient
	private Boolean isApproved;
	 @Column(name = "reset_password_token")
	    private String resetPasswordToken;
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @ManyToMany
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	            )
	private Set<RoleTB> roles = new HashSet<>();

	public User(int id, String name, String email, Date email_verified_at, String password, int role, String roleName,
			String remember_token, String mobileNumber, String profile_photo_path, LocalDateTime created_at, LocalDateTime updated_at,Boolean isApproved) {
		super();
		this.user_id = id;
		this.name = name;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.role = role;
		this.roleName = roleName;
		this.remember_token = remember_token;
		this.mobileNumber = mobileNumber;
		this.profile_photo_path = profile_photo_path;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.isApproved=isApproved;
	}
	
	public LocalDateTime getApproved_date() {
		return approved_date;
	}

	public void setApproved_date(LocalDateTime approved_date) {
		this.approved_date = approved_date;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int id) {
		this.user_id = id;
	}
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
	public Date getEmail_verified_at() {
		return email_verified_at;
	}
	public void setEmail_verified_at(Date email_verified_at) {
		this.email_verified_at = email_verified_at;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemember_token() {
		return remember_token;
	}
	public void setRemember_token(String remember_token) {
		this.remember_token = remember_token;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getProfile_photo_path() {
		return profile_photo_path;
	}
	public void setProfile_photo_path(String profile_photo_path) {
		this.profile_photo_path = profile_photo_path;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public Set<RoleTB> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleTB> roles) {
		this.roles = roles;
	}
	
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}
	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}
	

	public StatusUpdates getStatusdescription() {
		return statusdescription;
	}

	public void setStatusdescription(StatusUpdates statusdescription) {
		this.statusdescription = statusdescription;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [statusdescription=" + statusdescription + ", user_id=" + user_id + ", status=" + status
				+ ", name=" + name + ", email=" + email + ", email_verified_at=" + email_verified_at + ", password="
				+ password + ", role=" + role + ", roleName=" + roleName + ", remember_token=" + remember_token
				+ ", mobileNumber=" + mobileNumber + ", profile_photo_path=" + profile_photo_path + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", approved_date=" + approved_date + ", isApproved="
				+ isApproved + ", resetPasswordToken=" + resetPasswordToken + ", roles=" + roles + "]";
	}



	
	



}
