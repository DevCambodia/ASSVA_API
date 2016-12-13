package com.asva.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asva.model.Category;
import com.asva.model.form.CategoryAddForm;
import com.asva.model.form.CategoryAddForm.CategoryUpdateForm;
import com.asva.repository.CategoryRepository;
import com.asva.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository repo;
	
	@Override
	public ArrayList<Category> getAllCategories() {
		return repo.getAllCategories();
	}

	@Override
	public ArrayList<Category> getAllSubCategoriesByMainCategoryId(int mainCategoryId) {
		return repo.getAllSubCategoriesByMainCategoryId(mainCategoryId);
	}

	@Override
	public Category getCategoryById(int categoryId) {
		return repo.getCategoryById(categoryId);
	}

	@Override
	public boolean addCategory(CategoryAddForm category) {
		return repo.addCategory(category);
	}

	@Override
	public boolean updateCategory(CategoryUpdateForm category) {
		// if not main category
		if(category.getMainCategoryId()!=null){
			return repo.updateCategory(category);
		}else{
			// if category is main category, so update it's sub category
			if(repo.updateCategory(category)){
//				if(repo.toggleSubCategoryStatus(category))
//					return true;
//				else{ // in case of failure
//					// reverse category status
//					if(category.getCategoryStatus()==1)
//						category.setCategoryStatus(0);
//					else
//						category.setCategoryStatus(1);
//					
//					// start reverse toggle
//					return repo.updateCategory(category);
//				}
				repo.toggleSubCategoryStatus(category);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteCategoryById(Category category) {
		return repo.deleteCategoryById(category);
	}

	@Override
	public ArrayList<Category> getAllCategoriesThatItemsExist() {
		return repo.getAllCategoriesThatItemsExist();
	}

}
