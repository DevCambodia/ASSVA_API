package com.asva.model.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryAddForm{
	@JsonProperty("CATEGORY_NAME")
	private String categoryName;
	@JsonProperty("CATEGORY_IMAGE")
	private String categoryImage;
	@JsonProperty("CATEGORY_STATUS")
	private int categoryStatus;
	@JsonProperty("MAIN_CATEGORY_ID")
	private Integer mainCategoryId;
	
	public CategoryAddForm(){}

	public CategoryAddForm(String categoryName, String categoryImage, int categoryStatus, Integer mainCategoryId) {
		super();
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
		this.categoryStatus = categoryStatus;
		this.mainCategoryId = mainCategoryId;
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

	public Integer getMainCategoryId() {
		return mainCategoryId;
	}

	public void setMainCategoryId(Integer mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}

	@Override
	public String toString() {
		return "CategoryAddForm [categoryName=" + categoryName + ", categoryImage=" + categoryImage
				+ ", categoryStatus=" + categoryStatus + ", mainCategoryId=" + mainCategoryId + "]";
	};
	
	public static class CategoryUpdateForm extends CategoryAddForm{
		@JsonProperty("ID")
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
}
