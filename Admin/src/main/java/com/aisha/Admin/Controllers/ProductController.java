package com.aisha.Admin.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aisha.Admin.Entity.Product;
import com.aisha.Admin.Handlers.FileUploadUtil;
import com.aisha.Admin.Services.CategoryService;
import com.aisha.Admin.Services.ProductService;
import com.aisha.Admin.Services.SubCategoryService;
import com.aisha.Admin.Services.SubSubCategoryService;



@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private SubSubCategoryService subSubCategoryService;

	@GetMapping("/products")
	public String ViewProductList(Model model) {

		productService.getAllProducts().stream().forEach(t -> {
			if (categoryService.findByCategoryId(t.getCategory_ID()).isPresent())
				t.setCategoryDetails(categoryService.findByCategoryId(t.getCategory_ID()).get());
			if (subCategoryService.findBySubCategoryIdentity(t.getCategory_ID(), t.getSub_Category_ID()).isPresent())
				t.setSubCategoryDetails(
						subCategoryService.findBySubCategoryIdentity(t.getCategory_ID(), t.getSub_Category_ID()).get());
			if (subSubCategoryService.findBySubSubCategoryIdentity(t.getCategory_ID(), t.getSub_Category_ID(),
					t.getSub_Sub_Category_ID()).isPresent())
				t.setSubSubCategoryDetails(subSubCategoryService.findBySubSubCategoryIdentity(t.getCategory_ID(),
						t.getSub_Category_ID(), t.getSub_Sub_Category_ID()).get());
		});
		model.addAttribute("Products", productService.getAllProducts());
		return "Products";
	}

	@GetMapping("/products/add")
	public String redirectToAddProductPage(Model model) {
		model.addAttribute("ProductItem", new Product());
		model.addAttribute("AllCategories", categoryService.getAllCategories());
		return "AddProduct";
	}

	@PostMapping("/products/add")
	public String saveProduct(@ModelAttribute Product newProduct,
			@RequestParam(name = "mainproductimage", required = false) MultipartFile multipartFile,
			@RequestParam(name = "technicaldiagram", required = false) MultipartFile technical,
			@RequestParam(name = "productthumpnail1", required = false) MultipartFile thumpnail1,
			@RequestParam(name = "productthumpnail2", required = false) MultipartFile thumpnail2,
			@RequestParam(name = "productthumpnail3", required = false) MultipartFile thumpnail3,
			@RequestParam(name = "productthumpnail4", required = false) MultipartFile thumpnail4,
			@RequestParam(name = "productthumpnail5", required = false) MultipartFile thumpnail5,
			@RequestParam(name = "productthumpnail6", required = false) MultipartFile thumpnail6) throws IOException {
		try {
			
			if (categoryService.findByCategoryId(newProduct.getCategory_ID()).isPresent())
				newProduct.setCategory(
						categoryService.findByCategoryId(newProduct.getCategory_ID()).get().getCategory_Name());

			String uploadDir = "product-images/" + newProduct.getProduct_id();
			if (multipartFile != null) {
				String MainfileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				newProduct.setMainImage(MainfileName);
				FileUploadUtil.saveFile(uploadDir, MainfileName, multipartFile);
			} else {
				newProduct.setMainImage("");
			}
			if (technical != null) {
				String uploadTechDir ="technical-sheet/" + newProduct.getProduct_id();
				String MainfileName = StringUtils.cleanPath(technical.getOriginalFilename());
				newProduct.setTechnicalSheet(MainfileName);
				FileUploadUtil.saveFile(uploadTechDir, MainfileName, technical);
			} else {
				newProduct.setTechnicalSheet("");
			}
			if (thumpnail1 != null) {
				String MainfileName = StringUtils.cleanPath(thumpnail1.getOriginalFilename());
				newProduct.setThumpnail1(MainfileName);
				FileUploadUtil.saveFile(uploadDir, MainfileName, thumpnail1);
			} else {
				newProduct.setThumpnail1("");
			}
			if (thumpnail2 != null) {
				String MainfileName = StringUtils.cleanPath(thumpnail2.getOriginalFilename());
				newProduct.setThumpnail2(MainfileName);
				FileUploadUtil.saveFile(uploadDir, MainfileName, thumpnail2);
			} else {
				newProduct.setThumpnail2("");
			}
			if (thumpnail3 != null) {
				String MainfileName = StringUtils.cleanPath(thumpnail3.getOriginalFilename());
				newProduct.setThumpnail3(MainfileName);
				FileUploadUtil.saveFile(uploadDir, MainfileName, thumpnail3);
			} else {
				newProduct.setThumpnail3("");
			}
			if (thumpnail4 != null) {
				String MainfileName = StringUtils.cleanPath(thumpnail4.getOriginalFilename());
				newProduct.setThumpnail4(MainfileName);
				FileUploadUtil.saveFile(uploadDir, MainfileName, thumpnail4);
			} else {
				newProduct.setThumpnail4("");
			}
			if (thumpnail5 != null) {
				String MainfileName = StringUtils.cleanPath(thumpnail5.getOriginalFilename());
				newProduct.setThumpnail5(MainfileName);
				FileUploadUtil.saveFile(uploadDir, MainfileName, thumpnail5);
			} else {
				newProduct.setThumpnail5("");
			}
			if (thumpnail6 != null) {
				String MainfileName = StringUtils.cleanPath(thumpnail6.getOriginalFilename());
				newProduct.setThumpnail6(MainfileName);
				FileUploadUtil.saveFile(uploadDir, MainfileName, thumpnail6);
			} else {
				newProduct.setThumpnail6("");
			}
			System.out.println(newProduct.toString());
			productService.saveProduct(newProduct);


		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "redirect:/products";
	}
	
	@GetMapping("/products/update/{Product_id}")
	public String updateProduct(@PathVariable("Product_id") String Product_id, Model model) {
		try{
				Product ProductItem = productService.findProductById(Product_id).orElse(new Product());
				String category_id = "";
				String sub_category_id = "";
				if(ProductItem.getCategory_ID()!=null && !(ProductItem.getCategory_ID().equalsIgnoreCase("")))
					category_id = ProductItem.getCategory_ID();
				if(ProductItem.getSub_Category_ID()!=null && !(ProductItem.getSub_Category_ID().equalsIgnoreCase("")))
					sub_category_id = ProductItem.getSub_Category_ID();
				model.addAttribute("ProductItem", ProductItem);
				model.addAttribute("AllCategories", categoryService.getAllCategories());
				if(!category_id.equalsIgnoreCase(""))
					model.addAttribute("subcategories", subCategoryService.getAllSubCategoryOfSelected(category_id));
				if(!category_id.equalsIgnoreCase("") && !sub_category_id.equalsIgnoreCase(""))
					model.addAttribute("subsubcategories", subSubCategoryService.getAllSubSubCategoryOfSelected(category_id,sub_category_id));
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return "editproduct";
	}
	
	@GetMapping("/products/view/{Product_id}")
	public String ViewProduct(@PathVariable("Product_id") String Product_id, Model model) { 
		try{
				Product ProductItem = productService.findProductById(Product_id).orElse(new Product());
				if (categoryService.findByCategoryId(ProductItem.getCategory_ID()).isPresent())
					ProductItem.setCategoryDetails(categoryService.findByCategoryId(ProductItem.getCategory_ID()).get());
				if (subCategoryService.findBySubCategoryIdentity(ProductItem.getCategory_ID(), ProductItem.getSub_Category_ID()).isPresent())
					ProductItem.setSubCategoryDetails(
							subCategoryService.findBySubCategoryIdentity(ProductItem.getCategory_ID(), ProductItem.getSub_Category_ID()).get());
				if (subSubCategoryService.findBySubSubCategoryIdentity(ProductItem.getCategory_ID(), ProductItem.getSub_Category_ID(),
						ProductItem.getSub_Sub_Category_ID()).isPresent())
					ProductItem.setSubSubCategoryDetails(subSubCategoryService.findBySubSubCategoryIdentity(ProductItem.getCategory_ID(),
							ProductItem.getSub_Category_ID(), ProductItem.getSub_Sub_Category_ID()).get());
				model.addAttribute("ProductItem", ProductItem);
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return "viewproduct";
	}
	
	@GetMapping("/products/delete/{Product_id}")
	public String deleteProduct(@PathVariable("Product_id") String Product_id, Model model) { 
		try{
			productService.deleteProductById(Product_id);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "redirect:/products";
	}
}
