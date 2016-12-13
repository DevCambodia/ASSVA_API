package com.asva.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRole extends BaseModel{
	/*
	 * - High Priority Admin (Can use all functions)
	 * - Normal Priority Admin (Controll Item & User)
	 * - Low Priority Admin (Manage Banner)
	 * - Member (Post Item and manage their information)
	 * */
	@JsonProperty("ROLE_NAME")
	private String role_name;

	public UserRole(){}
	
	public UserRole(String role_name) {
		super();
		this.role_name = role_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "UserRole [role_name=" + role_name + "]";
	}
	
}
