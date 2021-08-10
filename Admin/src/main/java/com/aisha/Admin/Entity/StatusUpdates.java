package com.aisha.Admin.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status_tb")
public class StatusUpdates {
	@Id
	private int statuscode;
	private String status;
	public StatusUpdates(int statuscode, String status) {
		super();
		this.statuscode = statuscode;
		this.status = status;
	}
	public StatusUpdates() {
		
	}
	@Override
	public String toString() {
		return "StatusUpdates [statuscode=" + statuscode + ", status=" + status + "]";
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
