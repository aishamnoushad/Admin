package com.aisha.Admin.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.Admin.Entity.Categories;
import com.aisha.Admin.Repository.CategoryRepository;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Categories> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Optional<Categories> findByCategoryId(String id) {
		return categoryRepository.findById(id);
	}
	
	
	public Categories saveCategory(Categories newCategory) {
		
		if(newCategory.getFromValue().equalsIgnoreCase("Add") ) {
			newCategory.setCreated_at(LocalDateTime.now());
			newCategory.setUpdated_at(LocalDateTime.now());
		}else {
			newCategory.setUpdated_at(LocalDateTime.now());
			if(!categoryRepository.findById(newCategory.getCategory_ID()).isPresent())
			    newCategory.setCreated_at(LocalDateTime.now());
//			System.out.println(newCategory.getFromValue()+" and created at"+ newCategory.getCreated_at());
		}
		return categoryRepository.saveAndFlush(newCategory);
	}
	
	
	public void deleteCategory(String CatId) {
		categoryRepository.deleteById(CatId);
	}

}
