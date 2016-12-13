package com.asva.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asva.model.Item;
import com.asva.model.form.ItemAddForm;
import com.asva.model.form.ItemAddForm.ItemUpdateForm;
import com.asva.repository.ItemRepository;
import com.asva.service.ItemService;
import com.asva.util.filter.ItemFilter;
import com.asva.util.paging.Paging;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repo;
	
	@Override
	public ArrayList<Item> getAllItems() {
		return repo.getAllItems();
	}

	@Override
	public ArrayList<Item> getAllItemsByUserId(ItemFilter filter, Paging paging) {
		//return repo.getAllItemsByUserId(userId);
		try{
			paging.setTotalCount(repo.countWithUserId(filter));
			return repo.getAllItemsByUserId(filter, paging);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Item> getAllItemsByCategoryId(int categoryId) {
		return repo.getAllItemsByCategoryId(categoryId);
	}

	@Override
	public Item getItemByItem(int itemId) {
		return repo.getItemByItem(itemId);
	}

	@Override
	public boolean addItem(ItemAddForm item) {
		return repo.addItem(item);
	}

	@Override
	public boolean updateItem(ItemUpdateForm item) {
		return repo.updateItem(item);
	}

	@Override
	public boolean updateIsSoldByItemId(ItemUpdateForm item) {
		return repo.updateIsSoldByItemId(item);
	}

	@Override
	public boolean deleteItemById(Item item) {
		return repo.deleteItemById(item);
	}

	@Override
	public ArrayList<Item> getItemWithPaging(ItemFilter filter, Paging paging) {
		try{
			paging.setTotalCount(repo.count(filter));
			return repo.getItemWithPaging(filter, paging);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Item> getItemWithPagingWithoutCatId(ItemFilter filter, Paging paging) {
		try{
			paging.setTotalCount(repo.countWithoutCatId(filter));
			return repo.getItemWithPagingWithoutCatId(filter, paging);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
