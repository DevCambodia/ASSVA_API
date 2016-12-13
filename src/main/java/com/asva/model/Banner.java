package com.asva.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Banner extends BaseModel{
	@JsonProperty("BANNER_IMAGE")
	private String bannerImage;
	@JsonProperty("BANNER_POSITION")
	private String bannerPosition;
	
	/*
	 * Banner Position Note
	 * - Fixed
	 * - Scroll
	 * - None: when user hide it
	 * */
	@JsonProperty("BANNER_POSITION_TYPE")
	private String bannerPositionType;
	@JsonProperty("BANNER_WIDTH")
	private int bannerWidth;
	@JsonProperty("BANNER_HEIGHT")
	private int bannerHeight;
	private String bannerUrl;
	
	public Banner() {}

	public Banner(String bannerImage, String bannerPosition, String bannerPositionType, int bannerWidth,
			int bannerHeight, String bannerUrl) {
		super();
		this.bannerImage = bannerImage;
		this.bannerPosition = bannerPosition;
		this.bannerPositionType = bannerPositionType;
		this.bannerWidth = bannerWidth;
		this.bannerHeight = bannerHeight;
		this.bannerUrl = bannerUrl;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public String getBannerPosition() {
		return bannerPosition;
	}

	public void setBannerPosition(String bannerPosition) {
		this.bannerPosition = bannerPosition;
	}

	public String getBannerPositionType() {
		return bannerPositionType;
	}

	public void setBannerPositionType(String bannerPositionType) {
		this.bannerPositionType = bannerPositionType;
	}

	public int getBannerWidth() {
		return bannerWidth;
	}

	public void setBannerWidth(int bannerWidth) {
		this.bannerWidth = bannerWidth;
	}

	public int getBannerHeight() {
		return bannerHeight;
	}

	public void setBannerHeight(int bannerHeight) {
		this.bannerHeight = bannerHeight;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	@Override
	public String toString() {
		return "Banner [bannerImage=" + bannerImage + ", bannerPosition=" + bannerPosition + ", bannerPositionType="
				+ bannerPositionType + ", bannerWidth=" + bannerWidth + ", bannerHeight=" + bannerHeight
				+ ", bannerUrl=" + bannerUrl + "]";
	}
}
