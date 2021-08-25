package com.aisha.Admin.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisha.Admin.Entity.Categories;
import com.aisha.Admin.Services.CategoryService;
import com.aisha.Admin.Services.SubCategoryService;
import com.aisha.Admin.Services.SubSubCategoryService;



@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private SubSubCategoryService subSubCategoryService;
	
	@RequestMapping("/category")
	public String redirectTocategory(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "category";
	}
	
	@GetMapping("/category/add")
	public String redirectToCategoryAdditionPage(Model model) {
		model.addAttribute("categories", new Categories());
		return "categoryadd";
	}
	@PostMapping("/category/add")
	public String postSaveCategory( @Valid @ModelAttribute Categories newCategory) {
		categoryService.saveCategory(newCategory);
		return "redirect:/category";
	}
	
	@GetMapping("/category/delete/{category_id}")
	public String postdeleteCategory(@PathVariable("category_id") String CategoryId) {
		categoryService.deleteCategory(CategoryId);
		return "redirect:/category";
	}
	
	@GetMapping("/category/update/{category_id}")
	public String updateViewCategory(@PathVariable("category_id") String CategoryId, Model model) {
		try {
//			if(categoryService.findByCategoryId(CategoryId).isPresent())
				model.addAttribute("selCategory", categoryService.findByCategoryId(CategoryId).get());
				
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return "updateCategory";
	}

}
