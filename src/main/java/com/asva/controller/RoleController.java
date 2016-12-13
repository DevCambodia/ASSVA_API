package com.asva.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asva.model.user.Role;
import com.asva.service.user.UserService;
import com.asva.util.response.ResponseCode;
import com.asva.util.response.ResponseList;

import io.swagger.annotations.ApiOperation;

@RestController
public class RoleController {

	@Autowired
	private UserService userService;
	
	/***
	 * Get All Roles
	 * @return
	 */
	@ApiOperation("Get All User's Role")
	@RequestMapping(value = "/api/user/role", method = RequestMethod.GET)
	public ResponseList<Role> findAllRoles() {
		ResponseList<Role> response = new ResponseList<>();
		ArrayList<Role> roles = userService.findAllRoles();
		if (roles.isEmpty())
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		response.setData(roles);
		return response;
	}
	
}
