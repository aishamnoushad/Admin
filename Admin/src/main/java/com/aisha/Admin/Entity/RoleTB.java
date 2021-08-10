package com.aisha.Admin.Entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles_tb")
public class RoleTB implements Serializable{
	private static final long serialVersionUID = 5381833182834534405L;
	@Id
	@Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role_id;
	private String role_name;
	public RoleTB()
	{	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public RoleTB(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
	@Override
	public String toString() {
		return "RoleTB [role_id=" + role_id + ", role_name=" + role_name + "]";
	}
	
}
