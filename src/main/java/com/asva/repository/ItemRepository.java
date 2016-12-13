package com.asva.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.asva.model.Item;
import com.asva.model.form.ItemAddForm;
import com.asva.model.form.ItemAddForm.ItemUpdateForm;
import com.asva.util.filter.ItemFilter;
import com.asva.util.paging.Paging;

@Repository
public interface ItemRepository {
	
	/*
	 * CRUD
	 * */
	
	/*
	 * SQL
	 * */
	final String C_ITEM = "INSERT INTO tb_item(item_name, item_description, item_image, item_category_id, "
			+ "item_user_id, item_status, item_price) VALUES(#{itemName}, #{itemDescription}, #{itemImage}, "
			+ "#{itemCategoryId}, #{itemUserId}, #{itemStatus}, #{itemPrice})";
	
	final String C_ITEM_WITH_PAGING = "select "
				+ "TI.item_id, "
				+ "TI.item_name, "
				+ "TI.item_description, "
				+ "TI.item_image, "
				+ "TI.item_is_sold, "
				+ "TI.item_status,"
				+ "TI.item_price, "
				+ "TI.item_publish_date, TC.*, TU.* "
			+ "from tb_item TI "
			+ "inner join tb_category TC "
			+ "on TC.category_id = TI.item_category_id "
			+ "inner join tb_user TU "
			+ "on TU.user_id = TI.item_user_id "
			+ "WHERE LOWER(TI.item_name) LIKE '%' || LOWER(#{filter.itemName}) || '%' "
			+ "AND TI.item_category_id=#{filter.mainCategoryId} "
			+ "AND TI.item_status=1 "
			+ "ORDER BY TI.item_id DESC "
			+ "LIMIT #{paging.limit} "
			+ "OFFSET #{paging.offset}";
	
	final String C_ITEM_WITH_PAGING_WITHOUT_CAT_ID = "select "
			+ "TI.item_id, "
			+ "TI.item_name, "
			+ "TI.item_description, "
			+ "TI.item_image, "
			+ "TI.item_is_sold, "
			+ "TI.item_status,"
			+ "TI.item_price, "
			+ "TI.item_publish_date, TC.*, TU.* "
		+ "from tb_item TI "
		+ "inner join tb_category TC "
		+ "on TC.category_id = TI.item_category_id "
		+ "inner join tb_user TU "
		+ "on TU.user_id = TI.item_user_id "
		+ "WHERE LOWER(TI.item_name) LIKE '%' || LOWER(#{filter.itemName}) || '%' "
		+ "ORDER BY TI.item_id DESC "
		+ "LIMIT #{paging.limit} "
		+ "OFFSET #{paging.offset}";
	
	final String ITEM_COUNT = "select count(*) "
			+ "from tb_item TI "
			+ "INNER join tb_category TC "
			+ "ON TC.category_id=TI.item_category_id "
			+ "INNER JOIN tb_user TU "
			+ "ON TU.user_id = TI.item_user_id "
			+ "WHERE LOWER(TI.item_name) LIKE '%' || LOWER(#{itemName}) || '%' "
			+ "AND TI.item_category_id=#{mainCategoryId} "
			+ "AND TI.item_status=1";
	
	final String ITEM_COUNT_WITHOUT_CAT_ID = "select count(*) "
			+ "from tb_item TI "
			+ "INNER join tb_category TC "
			+ "ON TC.category_id=TI.item_category_id "
			+ "INNER JOIN tb_user TU "
			+ "ON TU.user_id = TI.item_user_id "
			+ "WHERE LOWER(TI.item_name) LIKE '%' || LOWER(#{itemName}) || '%' "
			+ "AND TI.item_status=1";
	
	final String ITEM_COUNT_WITH_USER_ID = "select count(*) "
			+ "from tb_item TI "
			+ "INNER join tb_category TC "
			+ "ON TC.category_id=TI.item_category_id "
			+ "INNER JOIN tb_user TU "
			+ "ON TU.user_id = TI.item_user_id "
			+ "WHERE LOWER(TI.item_name) LIKE '%' || LOWER(#{itemName}) || '%' "
			+ "AND TI.item_status <> 3 "
			+ "AND TU.user_id=#{userId}";
	
	final String R_ALL_ITEM = "select TI.item_id, TI.item_name, TI.item_description, TI.item_image, TI.item_is_sold, "
			+ "TI.item_status, TI.item_price, TI.item_publish_date, TC.*, TU.* "
			+ "from tb_item TI "
			+ "inner join tb_category TC "
			+ "on TC.category_id = TI.item_category_id "
			+ "inner join tb_user TU "
			+ "on TU.user_id = TI.item_user_id";
	
	final String R_ALL_ITEM_BY_USER_ID = "select TI.item_id, TI.item_name, TI.item_description, TI.item_image, TI.item_is_sold, "
			+ "TI.item_status, TI.item_price, TI.item_publish_date, TC.*, TU.* "
			+ "from tb_item TI "
			+ "inner join tb_category TC "
			+ "on TC.category_id = TI.item_category_id "
			+ "inner join tb_user TU "
			+ "on TU.user_id = TI.item_user_id "
			+ "WHERE LOWER(TI.item_name) LIKE '%' || LOWER(#{filter.itemName}) || '%' "
			+ "AND TI.item_user_id=#{filter.userId} "
			+ "ORDER BY TI.item_id DESC "
			+ "LIMIT #{paging.limit} "
			+ "OFFSET #{paging.offset}";
	
	final String R_ALL_ITEM_BY_CATEGORY_ID = "select TI.item_id, TI.item_name, TI.item_description, TI.item_image, TI.item_is_sold, "
			+ "TI.item_status, TI.item_price, TI.item_publish_date, TC.*, TU.* "
			+ "from tb_item TI "
			+ "inner join tb_category TC "
			+ "on TC.category_id = TI.item_category_id "
			+ "inner join tb_user TU "
			+ "on TU.user_id = TI.item_user_id "
			+ "WHERE TI.item_category_id=#{category.id}";
	
	final String R_ALL_ITEM_BY_ITEM_ID = "select TI.item_id, TI.item_name, TI.item_description, TI.item_image, TI.item_is_sold, "
			+ "TI.item_status, TI.item_price, TI.item_publish_date, TC.*, TU.* "
			+ "from tb_item TI "
			+ "inner join tb_category TC "
			+ "on TC.category_id = TI.item_category_id "
			+ "inner join tb_user TU "
			+ "on TU.user_id = TI.item_user_id "
			+ "WHERE TI.item_id=#{id}";
	
	final String U_ITEM = "UPDATE tb_item SET item_name=#{itemName}, item_description=#{itemDescription}, item_image=#{itemImage}, "
			+ "item_is_sold=#{itemIsSold}, item_category_id=${itemCategoryId}, item_user_id=#{itemUserId}, item_status=${itemStatus}, "
			+ "item_price=#{itemPrice} "
			+ "WHERE item_id=#{id}";
	
	final String U_ITEM_IS_SOLD_BY_ITEM_ID = "UPDATE tb_item SET item_is_sold=#{itemIsSold} WHERE item_id=#{id}";
	
	final String D_ITEM_BY_ID = "UPDATE tb_item SET item_status=#{itemStatus} WHERE item_id=#{id}";
	
	@Select(R_ALL_ITEM)
	@Results({
		@Result(property="id", column="item_id"),
		@Result(property="itemName", column="item_name"),
		@Result(property="itemDescription", column="item_description"),
		@Result(property="itemImage", column="item_image"),
		@Result(property="itemIsSold", column="item_is_sold"),
		@Result(property="itemStatus", column="item_status"),
		@Result(property="itemPrice", column="item_price"),
		@Result(property="itemPublishDate", column="item_publish_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.categoryImage", column="category_image"),
		@Result(property="category.categoryStatus", column="category_status"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.mainCategory.id", column="main_category_id"),
		@Result(property="user.id", column="user_id"),
		@Result(property="user.userFirstName", column="user_first_name"),
		@Result(property="user.userLastName", column="user_last_name"),
		@Result(property="user.userGender", column="user_gender"),
		@Result(property="user.userPassword", column="user_password"),
		@Result(property="user.userEmail", column="user_email"),
		@Result(property="user.userPhoto", column="user_photo"),
		@Result(property="user.userStatus", column="user_status"),
		@Result(property="user.userTelephone", column="user_telephone"),
		@Result(property="user.userRole.id", column="user_role"),
	})
	public ArrayList<Item> getAllItems();
	
	@Select(R_ALL_ITEM_BY_USER_ID)
	@Results({
		@Result(property="id", column="item_id"),
		@Result(property="itemName", column="item_name"),
		@Result(property="itemDescription", column="item_description"),
		@Result(property="itemImage", column="item_image"),
		@Result(property="itemIsSold", column="item_is_sold"),
		@Result(property="itemStatus", column="item_status"),
		@Result(property="itemPrice", column="item_price"),
		@Result(property="itemPublishDate", column="item_publish_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.categoryImage", column="category_image"),
		@Result(property="category.categoryStatus", column="category_status"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.mainCategory.id", column="main_category_id"),
		@Result(property="user.id", column="user_id"),
		@Result(property="user.userFirstName", column="user_first_name"),
		@Result(property="user.userLastName", column="user_last_name"),
		@Result(property="user.userGender", column="user_gender"),
		@Result(property="user.userPassword", column="user_password"),
		@Result(property="user.userEmail", column="user_email"),
		@Result(property="user.userPhoto", column="user_photo"),
		@Result(property="user.userStatus", column="user_status"),
		@Result(property="user.userTelephone", column="user_telephone"),
		@Result(property="user.userRole.id", column="user_role"),
	})
	public ArrayList<Item> getAllItemsByUserId(@Param("filter") ItemFilter filter, @Param("paging") Paging paging);
	
	@Select(R_ALL_ITEM_BY_CATEGORY_ID)
	@Results({
		@Result(property="id", column="item_id"),
		@Result(property="itemName", column="item_name"),
		@Result(property="itemDescription", column="item_description"),
		@Result(property="itemImage", column="item_image"),
		@Result(property="itemIsSold", column="item_is_sold"),
		@Result(property="itemStatus", column="item_status"),
		@Result(property="itemPrice", column="item_price"),
		@Result(property="itemPublishDate", column="item_publish_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.categoryImage", column="category_image"),
		@Result(property="category.categoryStatus", column="category_status"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.mainCategory.id", column="main_category_id"),
		@Result(property="user.id", column="user_id"),
		@Result(property="user.userFirstName", column="user_first_name"),
		@Result(property="user.userLastName", column="user_last_name"),
		@Result(property="user.userGender", column="user_gender"),
		@Result(property="user.userPassword", column="user_password"),
		@Result(property="user.userEmail", column="user_email"),
		@Result(property="user.userPhoto", column="user_photo"),
		@Result(property="user.userStatus", column="user_status"),
		@Result(property="user.userTelephone", column="user_telephone"),
		@Result(property="user.userRole.id", column="user_role"),
	})
	public ArrayList<Item> getAllItemsByCategoryId(int categoryId);
	
	@Select(R_ALL_ITEM_BY_ITEM_ID)
	@Results({
		@Result(property="id", column="item_id"),
		@Result(property="itemName", column="item_name"),
		@Result(property="itemDescription", column="item_description"),
		@Result(property="itemImage", column="item_image"),
		@Result(property="itemIsSold", column="item_is_sold"),
		@Result(property="itemStatus", column="item_status"),
		@Result(property="itemPrice", column="item_price"),
		@Result(property="itemPublishDate", column="item_publish_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.categoryImage", column="category_image"),
		@Result(property="category.categoryStatus", column="category_status"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.mainCategory.id", column="main_category_id"),
		@Result(property="user.id", column="user_id"),
		@Result(property="user.userFirstName", column="user_first_name"),
		@Result(property="user.userLastName", column="user_last_name"),
		@Result(property="user.userGender", column="user_gender"),
		@Result(property="user.userPassword", column="user_password"),
		@Result(property="user.userEmail", column="user_email"),
		@Result(property="user.userPhoto", column="user_photo"),
		@Result(property="user.userStatus", column="user_status"),
		@Result(property="user.userTelephone", column="user_telephone"),
		@Result(property="user.userRole.id", column="user_role"),
	})
	public Item getItemByItem(int itemId);
	
	@Select(C_ITEM_WITH_PAGING)
	@Results({
		@Result(property="id", column="item_id"),
		@Result(property="itemName", column="item_name"),
		@Result(property="itemDescription", column="item_description"),
		@Result(property="itemImage", column="item_image"),
		@Result(property="itemIsSold", column="item_is_sold"),
		@Result(property="itemStatus", column="item_status"),
		@Result(property="itemPrice", column="item_price"),
		@Result(property="itemPublishDate", column="item_publish_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.categoryImage", column="category_image"),
		@Result(property="category.categoryStatus", column="category_status"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.mainCategory.id", column="main_category_id"),
		@Result(property="user.id", column="user_id"),
		@Result(property="user.userFirstName", column="user_first_name"),
		@Result(property="user.userLastName", column="user_last_name"),
		@Result(property="user.userGender", column="user_gender"),
		@Result(property="user.userPassword", column="user_password"),
		@Result(property="user.userEmail", column="user_email"),
		@Result(property="user.userPhoto", column="user_photo"),
		@Result(property="user.userStatus", column="user_status"),
		@Result(property="user.userTelephone", column="user_telephone"),
		@Result(property="user.userRole.id", column="user_role"),
	})
	public ArrayList<Item> getItemWithPaging(@Param("filter") ItemFilter filter, @Param("paging") Paging paging);
	
	@Select(C_ITEM_WITH_PAGING_WITHOUT_CAT_ID)
	@Results({
		@Result(property="id", column="item_id"),
		@Result(property="itemName", column="item_name"),
		@Result(property="itemDescription", column="item_description"),
		@Result(property="itemImage", column="item_image"),
		@Result(property="itemIsSold", column="item_is_sold"),
		@Result(property="itemStatus", column="item_status"),
		@Result(property="itemPrice", column="item_price"),
		@Result(property="itemPublishDate", column="item_publish_date"),
		@Result(property="category.id", column="category_id"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.categoryImage", column="category_image"),
		@Result(property="category.categoryStatus", column="category_status"),
		@Result(property="category.categoryName", column="category_name"),
		@Result(property="category.mainCategory.id", column="main_category_id"),
		@Result(property="user.id", column="user_id"),
		@Result(property="user.userFirstName", column="user_first_name"),
		@Result(property="user.userLastName", column="user_last_name"),
		@Result(property="user.userGender", column="user_gender"),
		@Result(property="user.userPassword", column="user_password"),
		@Result(property="user.userEmail", column="user_email"),
		@Result(property="user.userPhoto", column="user_photo"),
		@Result(property="user.userStatus", column="user_status"),
		@Result(property="user.userTelephone", column="user_telephone"),
		@Result(property="user.userRole.id", column="user_role"),
	})
	public ArrayList<Item> getItemWithPagingWithoutCatId(@Param("filter") ItemFilter filter, @Param("paging") Paging paging);
	
	@Select(ITEM_COUNT)
	public Long count(ItemFilter filter);
	
	@Select(ITEM_COUNT_WITHOUT_CAT_ID)
	public Long countWithoutCatId(ItemFilter filter);
	
	@Select(ITEM_COUNT_WITH_USER_ID)
	public Long countWithUserId(ItemFilter filter);
	
	@Insert(C_ITEM)
	public boolean addItem(ItemAddForm item);
	
	@Update(U_ITEM)
	public boolean updateItem(ItemUpdateForm item);
	
	@Update(U_ITEM_IS_SOLD_BY_ITEM_ID)
	public boolean updateIsSoldByItemId(ItemUpdateForm item);
	
	@Delete(D_ITEM_BY_ID)
	public boolean deleteItemById(Item item);
}
