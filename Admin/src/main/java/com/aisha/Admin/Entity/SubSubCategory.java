package com.aisha.Admin.Entity;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="sub_sub_categories")
public class SubSubCategory {
	 @EmbeddedId
	SubSubCategoryIdentity subSubCategoryIdentity;
	
	 private String Sub_Sub_Category_Name;
	 private String  Description;
	 private String Status;
	 private LocalDateTime updated_at;
	 private LocalDateTime created_at;
	/**
	 * @return the subSubCategoryIdentity
	 */
	public SubSubCategoryIdentity getSubSubCategoryIdentity() {
		return subSubCategoryIdentity;
	}
	/**
	 * @param subSubCategoryIdentity the subSubCategoryIdentity to set
	 */
	public void setSubSubCategoryIdentity(SubSubCategoryIdentity subSubCategoryIdentity) {
		this.subSubCategoryIdentity = subSubCategoryIdentity;
	}
	/**
	 * @return the sub_Sub_Category_Name
	 */
	public String getSub_Sub_Category_Name() {
		return Sub_Sub_Category_Name;
	}
	/**
	 * @param sub_Sub_Category_Name the sub_Sub_Category_Name to set
	 */
	public void setSub_Sub_Category_Name(String sub_Sub_Category_Name) {
		Sub_Sub_Category_Name = sub_Sub_Category_Name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}
	/**
	 * @return the updated_at
	 */
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return the created_at
	 */
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public SubSubCategory(SubSubCategoryIdentity subSubCategoryIdentity, String sub_Sub_Category_Name,
			String description, String status, LocalDateTime updated_at, LocalDateTime created_at) {
		super();
		this.subSubCategoryIdentity = subSubCategoryIdentity;
		Sub_Sub_Category_Name = sub_Sub_Category_Name;
		Description = description;
		Status = status;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public SubSubCategory() {
		
	}
	
	//////non db fields/////
	@Transient
	@Autowired
	SubCategory subCategory;
	/**
	 * @return the subCategory
	 */
	// non db field //
		@Transient
		private String FromValue;
		public String getFromValue() {
			return FromValue;
		}
		public void setFromValue(String fromValue) {
			FromValue = fromValue;
		}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	
	
	public void setSubCategory(Optional<SubCategory> subCategory) {
		this.subCategory = subCategory.get();
	}
	
	 
}
