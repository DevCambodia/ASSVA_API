package com.asva.util.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemFilter extends BaseModelFilter{
	
	@JsonProperty("ITEM_NAME")
	public String itemName =  "";
	
	@JsonProperty("MAIN_CATEGORY_ID")
	public int mainCategoryId;
	
	@JsonProperty("USER_ID")
	public int userId;

	public ItemFilter(){}
	
	public ItemFilter(String itemName, int mainCategoryId, int userId) {
		super();
		this.itemName = itemName;
		this.mainCategoryId = mainCategoryId;
		this.userId = userId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getMainCategoryId() {
		return mainCategoryId;
	}

	public void setMainCategoryId(int mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ItemFilter [itemName=" + itemName + ", mainCategoryId=" + mainCategoryId + ", userId=" + userId + "]";
	}
}
