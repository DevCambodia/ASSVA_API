package com.asva.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asva.form.UserForm;
import com.asva.model.user.User;
import com.asva.service.user.UserService;
import com.asva.util.filter.UserFilter;
import com.asva.util.paging.Paging;
import com.asva.util.response.Response;
import com.asva.util.response.ResponseCode;
import com.asva.util.response.ResponseList;
import com.asva.util.response.ResponseRecord;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/***
 * @author PHEARUN
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	/***
	 * Save user
	 * 
	 * @param user	
	 * @return boolean
	 */
	@ApiOperation("Save User")
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public Response saveUser(@RequestBody User user) {
		Response response = new Response();
		if (userService.save(user))
			response.setCode(ResponseCode.INSERT_SUCCESS);

		return response;
	}

	/***
	 * Find all users with pagination
	 * 
	 * @param user
	 * @param page
	 * @param limit
	 * @return Array list of user
	 */

	@ApiImplicitParams({
			// Filter Param
			@ApiImplicitParam(name = "firstName", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by user's first name"),
			@ApiImplicitParam(name = "lastName", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by user's last name"),
			@ApiImplicitParam(name = "status", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by user's status"),
			@ApiImplicitParam(name = "roleName", dataType = "string", paramType = "query", defaultValue = "", value = "Filter by user's role"),

			// Paging Param
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", defaultValue = "1", value = "Page"),
			@ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue = "10", value = "Limit"), 
	})
	@ApiOperation("Get All Users")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseList<User> findAll(@ApiIgnore UserFilter filter, @ApiIgnore Paging paging) {
		ResponseList<User> response = new ResponseList<>();

		ArrayList<User> users = userService.findAll(filter, paging);

		if (users.isEmpty())
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);

		response.setData(users);
		response.setPaging(paging);
		return response;
	}

	/***
	 * Remove User
	 * 
	 * @param id
	 * @return boolean
	 */
	@ApiOperation("Delete User")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public Response removeUser(@PathVariable("id") int id) {
		Response response = new Response();
		if (userService.remove(id))
			response.setCode(ResponseCode.DELETE_SUCCESS);

		return response;
	}

	/***
	 * Update User
	 * 
	 * @param user
	 * @return boolean
	 */
	@ApiOperation("Update User")
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public Response updateUser(@RequestBody User user) {
		Response response = new Response();
		if (userService.update(user))
			response.setCode(ResponseCode.UPDATE_SUCCESS);

		return response;
	}

	/***
	 * Find one user by id
	 * 
	 * @param id
	 * @return User object
	 */
	@ApiOperation("Find one user by id")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseRecord<User> findOneUser(@PathVariable("id") int id) {

		ResponseRecord<User> response = new ResponseRecord<>();
		User user = userService.findOne(id);
		if (user == null)
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);

		response.setData(user);

		return response;
	}

	/***
	 * 
	 * @param userId
	 * @return
	 */
	@ApiOperation("Toggle user's status")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public Response updateStatus(@PathVariable("id") int userId) {

		Response response = new Response();
		
		if (userService.toggleStatus(userId))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);

		return response;
	}
	/***
	 * 
	 * @param userId
	 * @param pwd
	 * @return
	 */
	@ApiOperation("Reset user's password")
	@RequestMapping(value = "/user/reset", method = RequestMethod.PUT)
	public Response resetPassword(@RequestBody UserForm.ResetPasswordForm resetForm) {
		System.out.println("USER RESET==>" + resetForm);
		Response response = new Response();
		
		if (userService.resetPassword(resetForm))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);

		return response;
	}

	/***
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	@ApiOperation("Toggle user's status")
	@RequestMapping(value = "/user/role/{userId}/{roleId}", method = RequestMethod.PUT)
	public Response updateRole(@PathVariable("userId") int userId, @PathVariable("roleId") int roleId) {
		System.out.println("userId:"+userId +", "+ roleId);
		Response response = new Response();
		
		if (userService.updateRole(roleId, userId))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);

		return response;
	}
	
	@ApiOperation("login")
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ResponseRecord<User> updateRole(@RequestBody UserForm.LoginForm loginForm) {
		System.out.println("USER NAME==>" + loginForm.getEmail());
		System.out.println("USER NAME==>" + loginForm.getPassword());
		ResponseRecord<User> response = new ResponseRecord<>();
		User user = userService.findUserByEmail(loginForm);
		System.out.println("USER OBJECT===>" + user);
		if(user!=null){
			response.setCode(ResponseCode.RECORD_FOUND);
			response.setData(user);
		}else{
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		return response;
	}
	
}
