package com.asva.util.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author PHEARUN 
 * Created Date: 14/07/2016 
 * Email: rathphearun123@gmail.com
 * Credit: Dara Penhchet
 */
public class ResponseRecord<T> extends Response {

	@JsonProperty("DATA")
	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseRecord [data=" + data + "]";
	}
}
