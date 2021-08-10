package com.aisha.Admin.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.Admin.Entity.SubSubCategory;
import com.aisha.Admin.Entity.SubSubCategoryIdentity;
import com.aisha.Admin.Repository.SubSubCategoryRepository;



@Service
public class SubSubCategoryService {
	@Autowired
	SubSubCategoryRepository subSubCategoryRepository;
	
	public List<SubSubCategory> getAllSubSubCategories(){
		return subSubCategoryRepository.findAll();
	}
	
	public Optional<SubSubCategory> findBySubSubCategoryIdentity(String catid, String subcatid, String subsubcatid){
		
		return subSubCategoryRepository.findById( new SubSubCategoryIdentity(catid, subcatid, subsubcatid));
	}

	public SubSubCategory saveSubCategory(SubSubCategory newSubCategory) {
		if(newSubCategory.getFromValue().equalsIgnoreCase("Add")) {
			newSubCategory.setCreated_at(LocalDateTime.now());
			newSubCategory.setUpdated_at(LocalDateTime.now());
		}else {
			newSubCategory.setUpdated_at(LocalDateTime.now());
		}
		return subSubCategoryRepository.saveAndFlush(newSubCategory);
		
	}
	public void deleteSubSubCategory(String catid, String subcatid, String subsubcatid) {
		subSubCategoryRepository.deleteById(new SubSubCategoryIdentity(catid, subcatid, subsubcatid));;
	}
	
	public List<SubSubCategory> getAllSubSubCategoryOfSelected(String catid , String subcatid ){
		return subSubCategoryRepository.findAll().stream().filter(t->((t.getSubSubCategoryIdentity().getCategory_ID().equalsIgnoreCase(catid))&&(t.getSubSubCategoryIdentity().getSub_Category_ID().equalsIgnoreCase(subcatid)))).collect(Collectors.toList());
	}
}
