package com.asva.service;

import java.util.ArrayList;

import com.asva.model.Item;
import com.asva.model.form.ItemAddForm;
import com.asva.model.form.ItemAddForm.ItemUpdateForm;
import com.asva.util.filter.ItemFilter;
import com.asva.util.paging.Paging;

public interface ItemService {
	public ArrayList<Item> getItemWithPaging(ItemFilter filter, Paging paging);
	public ArrayList<Item> getItemWithPagingWithoutCatId(ItemFilter filter, Paging paging);
	public ArrayList<Item> getAllItems();
	public ArrayList<Item> getAllItemsByUserId(ItemFilter filter, Paging paging);
	public ArrayList<Item> getAllItemsByCategoryId(int categoryId);
	public Item getItemByItem(int itemId);
	public boolean addItem(ItemAddForm item);
	public boolean updateItem(ItemUpdateForm item);
	public boolean updateIsSoldByItemId(ItemUpdateForm item);
	public boolean deleteItemById(Item item);
} 
