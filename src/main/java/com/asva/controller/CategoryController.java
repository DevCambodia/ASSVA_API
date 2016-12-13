package com.asva.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asva.model.Category;
import com.asva.model.form.CategoryAddForm;
import com.asva.model.form.CategoryAddForm.CategoryUpdateForm;
import com.asva.resources.JSONResponse;
import com.asva.service.CategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@RequestMapping(method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get All Categories")
	public ResponseEntity<Map<String, Object>> getAllCategories(){
		Map<String, Object> map = new HashMap<>();
		try{
			ArrayList<Category> data = service.getAllCategories();
			if(data!=null){
				map.put(JSONResponse.Key.DATA, data);
				map.put(JSONResponse.Key.COUNT, data.size());
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.NO_RECORD_FOUND);
			}
		}catch(Exception e){e.printStackTrace();}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cat/exist", method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get All Categories With Items Exist")
	public ResponseEntity<Map<String, Object>> getAllCategoriesThatItemsExist(){
		Map<String, Object> map = new HashMap<>();
		try{
			ArrayList<Category> data = service.getAllCategoriesThatItemsExist();
			if(data!=null){
				map.put(JSONResponse.Key.DATA, data);
				map.put(JSONResponse.Key.COUNT, data.size());
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.NO_RECORD_FOUND);
			}
		}catch(Exception e){e.printStackTrace();}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/sub/{main_category_id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get All Sub Categories By Main Category Id")
	public ResponseEntity<Map<String, Object>> getAllSubCategoriesByMainCategoryId(@PathVariable("main_category_id") int mainCategoryId){
		Map<String, Object> map = new HashMap<>();
		try{
			ArrayList<Category> data = service.getAllSubCategoriesByMainCategoryId(mainCategoryId);
			if(data!=null){
				map.put(JSONResponse.Key.DATA, data);
				map.put(JSONResponse.Key.COUNT, data.size());
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.NO_RECORD_FOUND);
			}
		}catch(Exception e){e.printStackTrace();}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{category_id}", method=RequestMethod.GET, headers="Accept=application/json")
	@ApiOperation("Get Category By Id")
	public ResponseEntity<Map<String, Object>> getCategoryById(@PathVariable("category_id") int categoryId){
		Map<String, Object> map = new HashMap<>();
		try{
			Category data = service.getCategoryById(categoryId);
			if(data!=null){
				map.put(JSONResponse.Key.DATA, data);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.NO_RECORD_FOUND);
			}
		}catch(Exception e){e.printStackTrace();}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, headers="Accept=application/json")
	@ApiOperation("Add Category")
	public ResponseEntity<Map<String, Object>> addCategory(@RequestBody CategoryAddForm category){
		Map<String, Object> map = new HashMap<>();
		try{
			if(service.addCategory(category)){
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_SUCCESS);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_FAIL);
			}
		}catch(Exception e){e.printStackTrace();}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, headers="Accept=application/json")
	@ApiOperation("Update Category")
	public ResponseEntity<Map<String, Object>> updateCategory(@RequestBody CategoryUpdateForm category){
		Map<String, Object> map = new HashMap<>();
		try{
			if(service.updateCategory(category)){
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_SUCCESS);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_FAIL);
			}
		}catch(Exception e){e.printStackTrace();}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{category_id}", method=RequestMethod.DELETE, headers="Accept=application/json")
	@ApiOperation("Delete Category")
	public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable("category_id") int categoryId){
		Map<String, Object> map = new HashMap<>();
		try{
			Category category = new Category();
			category.setId(categoryId);
			if(service.deleteCategoryById(category)){
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_SUCCESS);
			}else{
				map.put(JSONResponse.Key.MESSAGE, JSONResponse.Value.TRANSACTION_FAIL);
			}
		}catch(Exception e){e.printStackTrace();}
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
}
