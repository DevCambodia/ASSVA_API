package com.asva.model.user;

import com.asva.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created Date: 14/07/2016
 * Author: Rath Phearun
 * Email: rathphearun123@gmail.com
 * 
 * */
public class Role extends BaseModel{
	
	/**
	 * 
	 * Admin : Full functionality for administrator.
	 * Editor: Control items and users.
	 * Ads   : Manage banner. 
	 * Member: Post their item and manage their information.
	 * 
	 * */
	
	@JsonProperty("NAME")
	private String name;

	public Role() {
		super();
	}

	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}

}
