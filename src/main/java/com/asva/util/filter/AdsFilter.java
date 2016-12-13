package com.asva.util.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author PHEARUN
 * Created Date: 14/07/2016
 * Email: rathphearun123@gmail.com
 * Reference: Dara Penhchet
 * */
public class AdsFilter extends BaseModelFilter{
	
	@JsonProperty("BY_OWNER")
	private String byOwner = "";
	
	@JsonProperty("BY_LOCATION")
	private String byLocation = "";
	
	@JsonProperty("BY_TYPE")
	private String byType = "";
	
	public AdsFilter(){}
	
	public AdsFilter(String byOwner, String byLocation, String byType) {
		super();
		this.byOwner = byOwner;
		this.byLocation = byLocation;
		this.byType = byType;
	}
	
	public String getByOwner() {
		return byOwner;
	}
	public void setByOwner(String byOwner) {
		this.byOwner = byOwner;
	}
	public String getByLocation() {
		return byLocation;
	}
	public void setByLocation(String byLocation) {
		this.byLocation = byLocation;
	}
	public String getByType() {
		return byType;
	}
	public void setByType(String byType) {
		this.byType = byType;
	}
	
	@Override
	public String toString() {
		return "AdsFilter [byOwner=" + byOwner + ", byLocation=" + byLocation + ", byType=" + byType + "]";
	}
	
	
}
