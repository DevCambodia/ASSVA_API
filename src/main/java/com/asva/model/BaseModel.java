package com.asva.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseModel {
	
	//hi vathana i've changed this id to protected
	@JsonProperty("ID")
	protected Integer id;
	
	public BaseModel(){}

	public BaseModel(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
