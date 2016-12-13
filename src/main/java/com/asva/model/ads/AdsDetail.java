package com.asva.model.ads;

import com.asva.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Created Date: 14/07/2016
 * Author: Rath Phearun
 * Email: rathphearun123@gmail.com
 * 
 * */
public class AdsDetail extends BaseModel{

	@JsonProperty("LOCATION")
	private String location;
	
	@JsonProperty("MAX_WIDTH")
	private int maxWidth;
		
	@JsonProperty("MAX_HEIGHT")
	private int maxHeight;
	
	/**
	 * ads type: 1(fixed), 0(relative)
	 * */
	@JsonProperty("TYPE")
	private int type;
	
	public AdsDetail(){
		
	}
	
	public AdsDetail(int id, String location, int maxWidth, int maxHeight, int type) {
		super();
		this.id = id;
		this.location = location;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.type = type;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMaxWidth() {
		return maxWidth;
	}
	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}
	public int getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AdsDetail [location=" + location + ", maxWidth=" + maxWidth + ", maxHeight=" + maxHeight
				+ ", type=" + type + "]";
	}
	
	
}
