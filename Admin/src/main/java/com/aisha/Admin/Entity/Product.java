package com.aisha.Admin.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name="Product_id")
	private String Product_id;
	@Column(name="FamilyCode")
	private String FamilyCode;
	@Column(name="barcode")
	private int Barcode;
	
	private String Category_ID;
	private String Sub_Category_ID;
	private String Sub_Sub_Category_ID;
	@Column(name="product_name")
	private String Product_name;
	@Column(name="shape")
	private String Shape;
	@Column(name="colour")
	private String Colour;
	@Column(name="size")
	private String Size;
	@Column(name="description")
	private String Description;
	@Column(name="long_description")
	private String Long_description;
	private String Available_sizes;
	private String Available_colours;
	private String Finish;
	@Column(name="material")
	private String Material;
	@Column(name="unit_in_stock")
	int Unit_in_stock;
	double Thickness;
	private double Dimension;
	@Column(name="outlet_diameter")
	double Outlet_diameter;
	private String Available_variance;
	private String Brand;
	private String Unit_of_measurement;
	double Unit_price;
	@Column(name="category")
	private String Category;
	private String Type;
	private String Application;
	@Column(name="MainImage")
	private String MainImage;
	@Column(name="Thumpnail1")
	private String Thumpnail1;
	@Column(name="Thumpnail2")
	private String Thumpnail2;
	@Column(name="Thumpnail3")
	private String Thumpnail3;
	@Column(name="Thumpnail4")
	private String Thumpnail4;
	@Column(name="Thumpnail5")
	private String Thumpnail5;
	@Column(name="Thumpnail6")
	private String Thumpnail6;
	@Column(name="TechnicalSheet")
	private String TechnicalSheet;
	@Column(name="created_at")
	private LocalDateTime Created_at;
	@Column(name="updated_at")
	private LocalDateTime Updated_at;

	
	public String getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}

	public String getFamilyCode() {
		return FamilyCode;
	}

	public void setFamilyCode(String familyCode) {
		FamilyCode = familyCode;
	}

	public int getBarcode() {
		return Barcode;
	}

	public void setBarcode(int barcode) {
		Barcode = barcode;
	}

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

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public String getShape() {
		return Shape;
	}

	public void setShape(String shape) {
		Shape = shape;
	}

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) {
		Colour = colour;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getLong_description() {
		return Long_description;
	}

	public void setLong_description(String long_description) {
		Long_description = long_description;
	}

	public String getAvailable_sizes() {
		return Available_sizes;
	}

	public void setAvailable_sizes(String available_sizes) {
		Available_sizes = available_sizes;
	}

	public String getAvailable_colours() {
		return Available_colours;
	}

	public void setAvailable_colours(String available_colours) {
		Available_colours = available_colours;
	}

	public String getFinish() {
		return Finish;
	}

	public void setFinish(String finish) {
		Finish = finish;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public int getUnit_in_stock() {
		return Unit_in_stock;
	}

	public void setUnit_in_stock(int unit_in_stock) {
		Unit_in_stock = unit_in_stock;
	}

	public double getThickness() {
		return Thickness;
	}

	public void setThickness(double thickness) {
		Thickness = thickness;
	}

	public double getDimension() {
		return Dimension;
	}

	public void setDimension(double dimension) {
		Dimension = dimension;
	}

	public double getOutlet_diameter() {
		return Outlet_diameter;
	}

	public void setOutlet_diameter(double outlet_diameter) {
		Outlet_diameter = outlet_diameter;
	}

	public String getAvailable_variance() {
		return Available_variance;
	}

	public void setAvailable_variance(String available_variance) {
		Available_variance = available_variance;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getUnit_of_measurement() {
		return Unit_of_measurement;
	}

	public void setUnit_of_measurement(String unit_of_measurement) {
		Unit_of_measurement = unit_of_measurement;
	}

	public double getUnit_price() {
		return Unit_price;
	}

	public void setUnit_price(double unit_price) {
		Unit_price = unit_price;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getApplication() {
		return Application;
	}

	public void setApplication(String application) {
		Application = application;
	}

	public String getMainImage() {
		return MainImage;
	}

	public void setMainImage(String mainImage) {
		MainImage = mainImage;
	}

	public String getThumpnail1() {
		return Thumpnail1;
	}

	public void setThumpnail1(String thumpnail1) {
		Thumpnail1 = thumpnail1;
	}

	public String getThumpnail2() {
		return Thumpnail2;
	}

	public void setThumpnail2(String thumpnail2) {
		Thumpnail2 = thumpnail2;
	}

	public String getThumpnail3() {
		return Thumpnail3;
	}

	public void setThumpnail3(String thumpnail3) {
		Thumpnail3 = thumpnail3;
	}

	public String getThumpnail4() {
		return Thumpnail4;
	}

	public void setThumpnail4(String thumpnail4) {
		Thumpnail4 = thumpnail4;
	}

	public String getThumpnail5() {
		return Thumpnail5;
	}

	public void setThumpnail5(String thumpnail5) {
		Thumpnail5 = thumpnail5;
	}

	public String getThumpnail6() {
		return Thumpnail6;
	}

	public void setThumpnail6(String thumpnail6) {
		Thumpnail6 = thumpnail6;
	}

	public String getTechnicalSheet() {
		return TechnicalSheet;
	}

	public void setTechnicalSheet(String technicalSheet) {
		TechnicalSheet = technicalSheet;
	}

	public LocalDateTime getCreated_at() {
		return Created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		Created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return Updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		Updated_at = updated_at;
	}

	public Product() {

	}

	

	public Product(String product_id, String familyCode, int barcode, String category_ID, String sub_Category_ID,
			String sub_Sub_Category_ID, String product_name, String shape, String colour, String size,
			String description, String long_description, String available_sizes, String available_colours,
			String finish, String material, int unit_in_stock, double thickness, double dimension,
			double outlet_diameter, String available_variance, String brand, String unit_of_measurement,
			double unit_price, String category, String type, String application, String mainImage, String thumpnail1,
			String thumpnail2, String thumpnail3, String thumpnail4, String thumpnail5, String thumpnail6,
			String technicalSheet, LocalDateTime created_at, LocalDateTime updated_at, Categories categoryDetails,
			SubCategory subCategoryDetails, SubSubCategory subSubCategoryDetails) {
		super();
		Product_id = product_id;
		FamilyCode = familyCode;
		Barcode = barcode;
		Category_ID = category_ID;
		Sub_Category_ID = sub_Category_ID;
		Sub_Sub_Category_ID = sub_Sub_Category_ID;
		Product_name = product_name;
		Shape = shape;
		Colour = colour;
		Size = size;
		Description = description;
		Long_description = long_description;
		Available_sizes = available_sizes;
		Available_colours = available_colours;
		Finish = finish;
		Material = material;
		Unit_in_stock = unit_in_stock;
		Thickness = thickness;
		Dimension = dimension;
		Outlet_diameter = outlet_diameter;
		Available_variance = available_variance;
		Brand = brand;
		Unit_of_measurement = unit_of_measurement;
		Unit_price = unit_price;
		Category = category;
		Type = type;
		Application = application;
		MainImage = mainImage;
		Thumpnail1 = thumpnail1;
		Thumpnail2 = thumpnail2;
		Thumpnail3 = thumpnail3;
		Thumpnail4 = thumpnail4;
		Thumpnail5 = thumpnail5;
		Thumpnail6 = thumpnail6;
		TechnicalSheet = technicalSheet;
		Created_at = created_at;
		Updated_at = updated_at;
		this.categoryDetails = categoryDetails;
		this.subCategoryDetails = subCategoryDetails;
		this.subSubCategoryDetails = subSubCategoryDetails;
	}



	@Override
	public String toString() {
		return "Product [Product_id=" + Product_id + ", FamilyCode=" + FamilyCode + ", Barcode=" + Barcode
				+ ", Category_ID=" + Category_ID + ", Sub_Category_ID=" + Sub_Category_ID + ", Sub_Sub_Category_ID="
				+ Sub_Sub_Category_ID + ", Product_name=" + Product_name + ", Shape=" + Shape + ", Colour=" + Colour
				+ ", Size=" + Size + ", Description=" + Description + ", Long_description=" + Long_description
				+ ", Available_sizes=" + Available_sizes + ", Available_colours=" + Available_colours + ", Finish="
				+ Finish + ", Material=" + Material + ", Unit_in_stock=" + Unit_in_stock + ", Thickness=" + Thickness
				+ ", Dimension=" + Dimension + ", Outlet_diameter=" + Outlet_diameter + ", Available_variance="
				+ Available_variance + ", Brand=" + Brand + ", Unit_of_measurement=" + Unit_of_measurement
				+ ", Unit_price=" + Unit_price + ", Category=" + Category + ", Type=" + Type + ", Application="
				+ Application + ", MainImage=" + MainImage + ", Thumpnail1=" + Thumpnail1 + ", Thumpnail2=" + Thumpnail2
				+ ", Thumpnail3=" + Thumpnail3 + ", Thumpnail4=" + Thumpnail4 + ", Thumpnail5=" + Thumpnail5
				+ ", Thumpnail6=" + Thumpnail6 + ", TechnicalSheet=" + TechnicalSheet + ", Created_at=" + Created_at
				+ ", Updated_at=" + Updated_at + ", categoryDetails=" + categoryDetails + ", subCategoryDetails="
				+ subCategoryDetails + ", subSubCategoryDetails=" + subSubCategoryDetails + "]";
	}



	/// out of db field///
	@Autowired
	@Transient
	Categories categoryDetails;
	@Autowired
	@Transient
	SubCategory subCategoryDetails;
	@Autowired
	@Transient
	SubSubCategory subSubCategoryDetails;
	
	// non db field //
		@Transient
		private String FromValue;
		public String getFromValue() {
			return FromValue;
		}
		public void setFromValue(String fromValue) {
			FromValue = fromValue;
		}

	public Categories getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(Categories categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public SubCategory getSubCategoryDetails() {
		return subCategoryDetails;
	}

	public void setSubCategoryDetails(SubCategory subCategoryDetails) {
		this.subCategoryDetails = subCategoryDetails;
	}

	public SubSubCategory getSubSubCategoryDetails() {
		return subSubCategoryDetails;
	}

	public void setSubSubCategoryDetails(SubSubCategory subSubCategoryDetails) {
		this.subSubCategoryDetails = subSubCategoryDetails;
	}

}
