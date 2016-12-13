package com.asva.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asva.model.Item;
import com.asva.model.form.ItemAddForm;
import com.asva.model.form.ItemAddForm.ItemUpdateForm;
import com.asva.resources.JSONResponse;
import com.asva.service.ItemService;
import com.asva.util.filter.ItemFilter;
import com.asva.util.paging.Paging;
import com.asva.util.response.ResponseCode;
import com.asva.util.response.ResponseList;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	/**
	 * Get All Item
	 * */
	@RequestMapping(method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get All Items")
	public ResponseEntity<Map<String, Object>> getAllItems(){
		Map<String, Object> map = new HashMap<>();
		try{
			ArrayList<Item> data = service.getAllItems();
			if(data!=null){
				map.put(JSONResponse.Key.DATA, data);
				map.put(JSONResponse.Key.COUNT, data.size());
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.NO_RECORD_FOUND);
			}
		}catch(Exception e){e.printStackTrace();}
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@ApiImplicitParams({
		// Filter Param
		@ApiImplicitParam(name = "itemName", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by item's name"),
		@ApiImplicitParam(name = "mainCategoryId", dataType = "integer", paramType = "query", defaultValue = "", value = "Filter by category id", required=true),

		// Paging Param
		@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "1", value = "Page"),
		@ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue = "10", value = "Limit"), 
	})	
	@ApiOperation("Get Item With Paging")
	@RequestMapping(value="/paging", method = RequestMethod.GET)
	public ResponseList<Item> getItemWithPaging(@ApiIgnore ItemFilter filter, @ApiIgnore Paging paging){
		ResponseList<Item> response = new ResponseList<>();

		List<Item> item = service.getItemWithPaging(filter, paging);

		if (item.isEmpty())
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		response.setData(item);
		response.setPaging(paging);
		return response;
	}
	
	@ApiImplicitParams({
		// Filter Param
		@ApiImplicitParam(name = "itemName", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by item's name"),
		// Paging Param
		@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "1", value = "Page"),
		@ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue = "10", value = "Limit"), 
	})	
	@ApiOperation("Get Item With Paging Without CatId")
	@RequestMapping(value="/paging/noCatId", method = RequestMethod.GET)
	public ResponseList<Item> getItemWithPagingWithoutCatId(@ApiIgnore ItemFilter filter, @ApiIgnore Paging paging){
		ResponseList<Item> response = new ResponseList<>();

		List<Item> item = service.getItemWithPagingWithoutCatId(filter, paging);

		if (item.isEmpty())
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		response.setData(item);
		response.setPaging(paging);
		return response;
	}
	
	/**
	 * Get Item By Item Id
	 * */
	@RequestMapping(value="/{item_id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get Item By Item Id")
	public ResponseEntity<Map<String, Object>> getAllItemsByItemId(@PathVariable("item_id") int itemId){
		Map<String, Object> map = new HashMap<>();
		try{
			Item data = service.getItemByItem(itemId);
			if(data!=null){
				map.put(JSONResponse.Key.DATA, data);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.NO_RECORD_FOUND);
			}
		}catch(Exception e){e.printStackTrace();}
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * Get All Item By User Id
	 * */
	@ApiImplicitParams({
		// Filter Param
		@ApiImplicitParam(name = "itemName", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by item's name"),
		@ApiImplicitParam(name = "userId", dataType = "integer", paramType = "query", defaultValue = "", value = "Filter by user's id", required=true),

		// Paging Param
		@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "1", value = "Page"),
		@ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue = "10", value = "Limit"), 
	})	
	@RequestMapping(value="/user", method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get All Items By User Id")
	public ResponseList<Item> getAllItemsByUserId(@ApiIgnore ItemFilter filter, @ApiIgnore Paging paging){
		ResponseList<Item> response = new ResponseList<>();
		
		ArrayList<Item> item = service.getAllItemsByUserId(filter, paging);
		
		if (item.isEmpty())
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		response.setData(item);
		response.setPaging(paging);
		return response;
	}
	
	/**
	 * Get All Item By Category Id
	 * */
	@RequestMapping(value="/category/{category_id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get All Items By Category Id")
	public ResponseEntity<Map<String, Object>> getAllItemsByCategoryId(@PathVariable("category_id") int categoryId){
		Map<String, Object> map = new HashMap<>();
		try{
			ArrayList<Item> data = service.getAllItemsByCategoryId(categoryId);
			if(data!=null){
				map.put(JSONResponse.Key.DATA, data);
				map.put(JSONResponse.Key.COUNT, data.size());
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.NO_RECORD_FOUND);
			}
		}catch(Exception e){e.printStackTrace();}
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * Add Item
	 * */
	@RequestMapping(method=RequestMethod.POST, headers="Accept=application/json")
	@ApiOperation("Add Item")
	public ResponseEntity<Map<String, Object>> addItem(@RequestBody ItemAddForm item){
		Map<String, Object> map = new HashMap<>();
		try{
			if(service.addItem(item)){
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_SUCCESS);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_FAIL);
			}
		}catch(Exception e){e.printStackTrace();}
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * Update Item
	 * */
	@RequestMapping(method=RequestMethod.PUT, headers="Accept=application/json")
	@ApiOperation("Update Item")
	public ResponseEntity<Map<String, Object>> updateItem(@RequestBody ItemUpdateForm item){
		Map<String, Object> map = new HashMap<>();
		try{
			if(service.updateItem(item)){
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_SUCCESS);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_FAIL);
			}
		}catch(Exception e){e.printStackTrace();}
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * Update Item sold status
	 * */
	@RequestMapping(value="/{item_id}/{is_sold}", method=RequestMethod.PUT, headers="Accept=application/json")
	@ApiOperation("Update Item isSold")
	public ResponseEntity<Map<String, Object>> updateIsSoldByItemId(@PathVariable("item_id") int itemId, 
			@PathVariable("is_sold") boolean isSold){
		Map<String, Object> map = new HashMap<>();
		try{
			ItemUpdateForm item = new ItemUpdateForm();
			item.setId(itemId);
			item.setItemIsSold(isSold);
			if(service.updateIsSoldByItemId(item)){
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_SUCCESS);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_FAIL);
			}
		}catch(Exception e){e.printStackTrace();}
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * Delete Item
	 * */
	@RequestMapping(value="/{item_id}", method=RequestMethod.DELETE, headers="Accept=application/json")
	@ApiOperation("Delete Item By Item Id")
	public ResponseEntity<Map<String, Object>> deleteItemById(@PathVariable("item_id") int itemId){
		Map<String, Object> map = new HashMap<>();
		try{
			Item item = new Item();
			item.setId(itemId);
			item.setItemStatus(3);
			if(service.deleteItemById(item)){
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_SUCCESS);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_FAIL);
			}
		}catch(Exception e){e.printStackTrace();}
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	
}
