package com.asva.model.ads;

import com.asva.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created Date: 14/07/2016
 * Author: Rath Phearun
 * Email: rathphearun123@gmail.com
 * 
 * */
public class Ads extends BaseModel{
	
	@JsonProperty("NAME")
	private String name;
	
	@JsonProperty("OWNER")
	private String owner;
	
	@JsonProperty("ORDER")
	private int order;
	
	@JsonProperty("IMAGE")
	private String image;

	@JsonProperty("LINK")
	private String link;
	
	@JsonProperty("WIDTH")
	private int width;
	
	@JsonProperty("HEIGHT")
	private int height;
	
	@JsonProperty("ADS_DETAIL")
	private AdsDetail adsDetail;
	
	@JsonProperty("STATUS")
	private int status = 1;
	
	public Ads(){
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AdsDetail getAdsDetail() {
		return adsDetail;
	}

	public void setAdsDetail(AdsDetail adsDetail) {
		this.adsDetail = adsDetail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ads [name=" + name + ", owner=" + owner + ", order=" + order + ", image=" + image + ", link=" + link
				+ ", width=" + width + ", height=" + height + ", adsDetail=" + adsDetail + ", status=" + status + "]";
	}
}
