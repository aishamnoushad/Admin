package com.aisha.Admin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisha.Admin.Entity.SubCategory;
import com.aisha.Admin.Services.CategoryService;
import com.aisha.Admin.Services.SubCategoryService;
import com.aisha.Admin.Services.SubSubCategoryService;

@Controller
public class SubCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private SubSubCategoryService subSubCategoryService;
	
	@RequestMapping("/subcategory")
	public String redirectToSubcategory(Model model) {
		subCategoryService.getAllSubCategory().stream().forEach(t->t.setCategories(categoryService.findByCategoryId(t.getSubCategoryIdentity().Category_ID)));
		model.addAttribute("subcategories", subCategoryService.getAllSubCategory());
		return "subcategory";
	}
	
	@GetMapping("/subcategory/add")
	public String redirectToCategoryAdditionPage(Model model) {
		model.addAttribute("subcategory", new SubCategory());
		model.addAttribute("AllCategories", categoryService.getAllCategories());
		return "addSubcategory";
	}
	@PostMapping("/subcategory/add")
	public String postSaveCategory(@ModelAttribute SubCategory newSubCategory) {
		subCategoryService.saveSubCategory(newSubCategory);
		return "redirect:/subcategory";
	}
	
	@GetMapping("/subcategory/delete/{category_id}/{sub_category_id}")
	public String postdeleteCategory(@PathVariable("category_id") String CategoryId, @PathVariable("sub_category_id") String SubCategoryId) {
		subCategoryService.deleteSubCategory(CategoryId,SubCategoryId);
		return "redirect:/subcategory";
	}
	
	@GetMapping("/subcategory/update/{category_id}/{sub_category_id}")
	public String updateViewSubCategory(@PathVariable("category_id") String CategoryId,@PathVariable("sub_category_id") String SubCategoryId, Model model) {
		try {
//			if(categoryService.findByCategoryId(CategoryId).isPresent())
				model.addAttribute("selSubCategory", subCategoryService.findBySubCategoryIdentity(CategoryId,SubCategoryId).get());
				model.addAttribute("AllCategories", categoryService.getAllCategories());
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return "updateSubCategory";
	}

}
