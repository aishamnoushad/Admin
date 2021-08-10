package com.aisha.Admin.Entity;


import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
@Table(name="sub_categories")
public class SubCategory {
   @EmbeddedId
	SubCategoryIdentity subCategoryIdentity;
	
	public String Sub_Category_Name;
	public String Description;
	public String Status;
	private LocalDateTime updated_at;
	private LocalDateTime created_at;
	public SubCategoryIdentity getSubCategoryIdentity() {
		return subCategoryIdentity;
	}
	public void setSubCategoryIdentity(SubCategoryIdentity subCategoryIdentity) {
		this.subCategoryIdentity = subCategoryIdentity;
	}
	public String getSub_Category_Name() {
		return Sub_Category_Name;
	}
	public void setSub_Category_Name(String sub_Category_Name) {
		Sub_Category_Name = sub_Category_Name;
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
	public SubCategory(SubCategoryIdentity subCategoryIdentity, String sub_Category_Name, String description,
			String status, LocalDateTime updated_at, LocalDateTime created_at) {
		super();
		this.subCategoryIdentity = subCategoryIdentity;
		Sub_Category_Name = sub_Category_Name;
		Description = description;
		Status = status;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public SubCategory() {
		
	}
	
	
	///////////
	//out of DB Values
	////////////////////
	@Transient
	@Autowired
	Categories categories;
	
	// non db field //
		@Transient
		private String FromValue;
		public String getFromValue() {
			return FromValue;
		}
		public void setFromValue(String fromValue) {
			FromValue = fromValue;
		}
	
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public void setCategories(Optional<Categories> categories) {
		this.categories = categories.get();
	}
	
	
	
}
