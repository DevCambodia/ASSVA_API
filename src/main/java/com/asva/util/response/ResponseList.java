package com.asva.util.response;

import java.util.List;

import com.asva.util.paging.Paging;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author PHEARUN
 * Created Date: 14/07/2016 
 * Email: rathphearun123@gmail.com
 * Credit: Dara Penhchet
 */
public class ResponseList<T> extends Response {

	@JsonProperty("DATA")
	public List<T> data;

	@JsonProperty("PAGING")
	public Paging paging;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
