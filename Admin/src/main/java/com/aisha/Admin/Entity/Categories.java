package com.aisha.Admin.Entity;

import java.time.LocalDateTime;  

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categories")
public class Categories { 
	@Id
	@NotNull(message = " is required") 
	@NotBlank(message = " is required and should not be blank")
	private String Category_ID;
	@NotNull(message = " is required")
	@NotBlank(message = " is required")
	private String Category_Name;
	@NotNull(message = " is required")
	@NotBlank(message = " is required")
	private String Description;
	@NotNull(message = " is required")
	@NotBlank(message = " is required")
	private String Status;
	private LocalDateTime updated_at;
	private LocalDateTime created_at;
	public String getCategory_ID() {
		return Category_ID;
	}
	public void setCategory_ID(String category_ID) {
		Category_ID = category_ID;
	}
	public String getCategory_Name() {
		return Category_Name;
	}
	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public Categories(String category_ID, String category_Name, String description, String status, LocalDateTime updated_at,
			LocalDateTime created_at) {
		super();
		Category_ID = category_ID;
		Category_Name = category_Name;
		Description = description;
		Status = status;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	public Categories() {
		
	}
	
	// non db field //
	@Transient
	private String FromValue;
	public String getFromValue() {
		return FromValue;
	}
	public void setFromValue(String fromValue) {
		FromValue = fromValue;
	}
	

}
