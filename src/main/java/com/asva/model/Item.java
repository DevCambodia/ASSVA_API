package com.asva.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item extends BaseModel{
	@JsonProperty("ITEM_NAME")
	private String itemName;
	@JsonProperty("ITEM_DESCRIPTION")
	private String itemDescription;
	@JsonProperty("ITEM_IMAGE")
	private String itemImage;
	
	/*
	 * Item isSold Note
	 * True = sold
	 * False = is not sold
	 * */
	@JsonProperty("ITEM_IS_SOLD")
	private boolean itemIsSold;
	
	/*
	 * Item Status Note:
	 * 1 = Show
	 * 2 = Hide
	 * 3 = Delete
	 * */
	@JsonProperty("ITEM_STATUS")
	private int itemStatus;
	@JsonProperty("ITEM_PRICE")
	private String itemPrice;
	@JsonProperty("ITEM_PUBLISH_DATE")
	private Date itemPublishDate;
	@JsonProperty("ITEM_USER")
	private User user;
	@JsonProperty("ITEM_CATEGORY")
	private Category category;
	
	public Item(){}
	
	public Item(String itemName, String itemDescription, String itemImage, boolean itemIsSold, int itemStatus,
			String itemPrice, Date itemPublishDate, User user, Category category) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemImage = itemImage;
		this.itemIsSold = itemIsSold;
		this.itemStatus = itemStatus;
		this.itemPrice = itemPrice;
		this.itemPublishDate = itemPublishDate;
		this.user = user;
		this.category = category;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public boolean isItemIsSold() {
		return itemIsSold;
	}
	public void setItemIsSold(boolean itemIsSold) {
		this.itemIsSold = itemIsSold;
	}
	public int getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Date getItemPublishDate() {
		return itemPublishDate;
	}
	public void setItemPublishDate(Date itemPublishDate) {
		this.itemPublishDate = itemPublishDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemDescription=" + itemDescription + ", itemImage=" + itemImage
				+ ", itemIsSold=" + itemIsSold + ", itemStatus=" + itemStatus + ", itemPrice=" + itemPrice
				+ ", itemPublishDate=" + itemPublishDate + ", user=" + user + ", category=" + category + "]";
	}
}
