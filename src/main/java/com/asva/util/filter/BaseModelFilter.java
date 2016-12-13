package com.asva.util.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author PHEARUN
 * Created Date: 14/07/2016
 * Email: rathphearun123@gmail.com
 * Reference: Dara Penhchet
 * */
public class BaseModelFilter {
	
	@JsonProperty("BY_STATUS")
	protected String status = "";
	
	public BaseModelFilter(){}

	public BaseModelFilter(String status) {
		super();
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BaseModelFilter [status=" + status + "]";
	}
	
	
}
