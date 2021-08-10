package com.aisha.Admin.Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.sun.istack.NotNull;
@Embeddable
public class SubSubCategoryIdentity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3884511996093478383L;
	@NotNull
	private String Category_ID;
	@NotNull
	private String Sub_Category_ID;
	@NotNull
	private String Sub_Sub_Category_ID;
	public String getCategory_ID() {
		return Category_ID;
	}
	public void setCategory_ID(String category_ID) {
		Category_ID = category_ID;
	}
	public String getSub_Category_ID() {
		return Sub_Category_ID;
	}
	public void setSub_Category_ID(String sub_Category_ID) {
		Sub_Category_ID = sub_Category_ID;
	}
	public String getSub_Sub_Category_ID() {
		return Sub_Sub_Category_ID;
	}
	public void setSub_Sub_Category_ID(String sub_Sub_Category_ID) {
		Sub_Sub_Category_ID = sub_Sub_Category_ID;
	}
	public SubSubCategoryIdentity(String category_ID, String sub_Category_ID, String sub_Sub_Category_ID) {
		super();
		Category_ID = category_ID;
		Sub_Category_ID = sub_Category_ID;
		Sub_Sub_Category_ID = sub_Sub_Category_ID;
	}
	public SubSubCategoryIdentity() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Category_ID == null) ? 0 : Category_ID.hashCode());
		result = prime * result + ((Sub_Category_ID == null) ? 0 : Sub_Category_ID.hashCode());
		result = prime * result + ((Sub_Sub_Category_ID == null) ? 0 : Sub_Sub_Category_ID.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubSubCategoryIdentity other = (SubSubCategoryIdentity) obj;
		if (Category_ID == null) {
			if (other.Category_ID != null)
				return false;
		} else if (!Category_ID.equals(other.Category_ID))
			return false;
		if (Sub_Category_ID == null) {
			if (other.Sub_Category_ID != null)
				return false;
		} else if (!Sub_Category_ID.equals(other.Sub_Category_ID))
			return false;
		if (Sub_Sub_Category_ID == null) {
			if (other.Sub_Sub_Category_ID != null)
				return false;
		} else if (!Sub_Sub_Category_ID.equals(other.Sub_Sub_Category_ID))
			return false;
		return true;
	}
	
	
}
