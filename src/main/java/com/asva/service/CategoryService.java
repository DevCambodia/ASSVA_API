package com.asva.service;

import java.util.ArrayList;

import com.asva.model.Category;
import com.asva.model.form.CategoryAddForm;
import com.asva.model.form.CategoryAddForm.CategoryUpdateForm;

public interface CategoryService {
	/**
	 * Get All Categories
	 * @return {@link ArrayList<Category>}
	 * */
	public ArrayList<Category> getAllCategories();
	
	/**
	 * Get All Sub Category By Main Category Id
	 * @param mainCategoryId
	 * @return {@link ArrayList<Category>}
	 * */
	public ArrayList<Category> getAllSubCategoriesByMainCategoryId(int mainCategoryId);
	
	/**
	 * Get All Categories that items exist in that category
	 * */
	public ArrayList<Category> getAllCategoriesThatItemsExist();
	
	/**
	 * Get Category By Category Id
	 * @param categoryId
	 * */
	public Category getCategoryById(int categoryId);
	
	/**
	 * Add Category
	 * @param category
	 * @return {@link Boolean}
	 * */
	public boolean addCategory(CategoryAddForm category);
	
	/**
	 * Update Category
	 * @param category
	 * @return {@link Boolean}
	 * */
	public boolean updateCategory(CategoryUpdateForm category);
	
	/**
	 * Delete Category By Id
	 * @param category
	 * @return {@link Boolean}
	 * */
	public boolean deleteCategoryById(Category category);
}
