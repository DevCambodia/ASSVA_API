package com.asva.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category extends BaseModel{
	@JsonProperty("CATEGORY_NAME")
	private String categoryName;
	@JsonProperty("CATEGORY_IMAGE")
	private String categoryImage;
	
	/*
	 * Category Note
	 * 0 = delete
	 * 1 = active
	 * */
	@JsonProperty("CATEGORY_STATUS")
	private int categoryStatus;
	@JsonProperty("MAIN_CATEGORY")
	private Category mainCategory;
	@JsonProperty("SUB_CAT_COUNT")
	private int subCatCount;
	@JsonProperty("ITEM_COUNT")
	private int itemCount;
	
	public Category(){
		setId(null);
	}

	public Category(String categoryName, String categoryImage, int categoryStatus, Category mainCategory,
			int subCatCount, int itemCount) {
		super();
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
		this.categoryStatus = categoryStatus;
		this.mainCategory = mainCategory;
		this.subCatCount = subCatCount;
		this.itemCount = itemCount;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategoryImage() {
		return categoryImage;
	}


	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}


	public int getCategoryStatus() {
		return categoryStatus;
	}


	public void setCategoryStatus(int categoryStatus) {
		this.categoryStatus = categoryStatus;
	}


	public Category getMainCategory() {
		return mainCategory;
	}


	public void setMainCategory(Category mainCategory) {
		this.mainCategory = mainCategory;
	}


	public int getSubCatCount() {
		return subCatCount;
	}


	public void setSubCatCount(int subCatCount) {
		this.subCatCount = subCatCount;
	}


	public int getItemCount() {
		return itemCount;
	}


	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", categoryImage=" + categoryImage + ", categoryStatus="
				+ categoryStatus + ", mainCategory=" + mainCategory + ", subCatCount=" + subCatCount + ", itemCount="
				+ itemCount + "]";
	}
}
