package com.asva.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.asva.model.Category;
import com.asva.model.form.CategoryAddForm;
import com.asva.model.form.CategoryAddForm.CategoryUpdateForm;

@Repository
public interface CategoryRepository {
	
	/*
	 * CRUD
	 * */
	
	/*
	 * SQL
	 * */
	final String C_CATEGORY = "INSERT INTO tb_category(category_name, category_image, main_category_id) "
			+ "VALUES (#{categoryName}, #{categoryImage}, #{mainCategoryId})";
	
	final String R_ALL_CATEGORY = "SELECT category_id, category_name, category_image, main_category_id, category_status, "
			+ "(SELECT CASE WHEN TC.main_category_id IS NULL THEN (SELECT CASE WHEN "
			+ "(SELECT COUNT(*) FROM tb_category TM WHERE TM.main_category_id=TC.category_id)>0 THEN 1 ELSE 0 END) END) AS sub_cat_count, "
			+ "(SELECT CASE WHEN TC.main_category_id IS NOT NULL THEN (SELECT CASE WHEN "
			+ "(SELECT COUNT(*) FROM tb_item TI WHERE TI.item_category_id=TC.category_id)>0 THEN 1 ELSE 0 END) ELSE (SELECT CASE WHEN  "
			+ "(SELECT COUNT(*) FROM tb_category TSS WHERE TSS.main_category_id=TC.category_id)>0 THEN 1 ELSE 0 END) END) AS item_count	"
			+ "FROM tb_category TC ORDER BY category_name ASC";
	
	final String R_ALL_CATEGORY_WITH_ITEM_EXIST = "SELECT category_id, category_name, category_image, main_category_id, "
			+ "(SELECT CASE WHEN (SELECT COUNT(*) FROM tb_item TI WHERE TI.item_category_id=TC.category_id) >0 THEN 1 "
			+ "WHEN TC.main_category_id=NULL then 1 ELSE 0 END AS category_status) FROM tb_category TC ORDER BY category_name ASC";
	
	final String R_ALL_SUB_CATEGORY_BY_MAIN_CATEGORY_ID = "SELECT TS.category_id, TS.category_name, TS.category_image, "
			+ "TS.category_status, TS.main_category_id "
			+ "FROM tb_category TM INNER JOIN tb_category TS "
			+ "ON TS.main_category_id = TM.category_id "
			+ "WHERE TS.main_category_id=#{id} ORDER BY TS.category_name ASC";
	
	final String R_CATEGORY_BY_ID = "SELECT * FROM tb_category "
			+ "WHERE category_id = #{id}";
	
	final String U_CATEGORY = "UPDATE tb_category SET category_name = #{categoryName}, category_image = #{categoryImage}, "
			+ "category_status = #{categoryStatus}, main_category_id=#{mainCategoryId} "
			+ "WHERE category_id=#{id}";
	
	final String D_CATEGORY_BY_ID = "UPDATE tb_category SET category_status = #{categoryStatus} "
			+ "WHERE category_id=#{id}";
	
	final String TOGGLE_CATEGORY_STATUS = "UPDATE tb_category SET category_status = #{categoryStatus} WHERE main_category_id=#{id}";
	
	@Select(R_ALL_CATEGORY)
	@Results({
		@Result(property="id", column="category_id"),
		@Result(property="categoryName", column="category_name"),
		@Result(property="categoryImage", column="category_image"),
		@Result(property="categoryStatus", column="category_status"),
		@Result(property="mainCategory.id", column="main_category_id"),
		@Result(property="itemCount", column="item_count"),
		@Result(property="subCatCount", column="sub_cat_count")
	})
	public ArrayList<Category> getAllCategories();
	
	@Select(R_ALL_SUB_CATEGORY_BY_MAIN_CATEGORY_ID)
	@Results({
		@Result(property="id", column="category_id"),
		@Result(property="categoryName", column="category_name"),
		@Result(property="categoryImage", column="category_image"),
		@Result(property="categoryStatus", column="category_status"),
		@Result(property="mainCategory.id", column="main_category_id")
	})
	public ArrayList<Category> getAllSubCategoriesByMainCategoryId(int mainCategoryId);
	
	@Select(R_ALL_CATEGORY_WITH_ITEM_EXIST)
	@Results({
		@Result(property="id", column="category_id"),
		@Result(property="categoryName", column="category_name"),
		@Result(property="categoryImage", column="category_image"),
		@Result(property="categoryStatus", column="category_status"),
		@Result(property="mainCategory.id", column="main_category_id")
	})
	public ArrayList<Category> getAllCategoriesThatItemsExist();
	
	@Select(R_CATEGORY_BY_ID)
	@Results({
		@Result(property="id", column="category_id"),
		@Result(property="categoryName", column="category_name"),
		@Result(property="categoryImage", column="category_image"),
		@Result(property="categoryStatus", column="category_status"),
		@Result(property="mainCategory.id", column="main_category_id")
	})
	public Category getCategoryById(int categoryId);
	
	@Insert(C_CATEGORY)
	public boolean addCategory(CategoryAddForm category);
	
	@Update(U_CATEGORY)
	public boolean updateCategory(CategoryUpdateForm category);
	
	@Update(TOGGLE_CATEGORY_STATUS)
	public boolean toggleSubCategoryStatus(CategoryUpdateForm category);
	
	@Delete(D_CATEGORY_BY_ID)
	public boolean deleteCategoryById(Category category);
}
