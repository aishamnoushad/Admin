package com.aisha.Admin.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_roles")
public class User_Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private int user_id;
	private int role_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public User_Roles() {
		
	}
	@Override
	public String toString() {
		return "User_Roles [slno=" + slno + ", user_id=" + user_id + ", role_id=" + role_id + "]";
	}
	public User_Roles( int user_id, int role_id) {
		super();
		
		this.user_id = user_id;
		this.role_id = role_id;
	}
	
	
}
