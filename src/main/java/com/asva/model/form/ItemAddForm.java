package com.asva.model.form;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemAddForm{
	@JsonProperty("ITEM_NAME")
	private String itemName;
	@JsonProperty("ITEM_DESCRIPTION")
	private String itemDescription;
	@JsonProperty("ITEM_IMAGE")
	private String itemImage;
	@JsonProperty("ITEM_IS_SOLD")
	private boolean itemIsSold;
	@JsonProperty("ITEM_STATUS")
	private int itemStatus;
	@JsonProperty("ITEM_PRICE")
	private String itemPrice;
	@JsonProperty("ITEM_PUBLISH_DATE")
	private Date itemPublishDate;
	@JsonProperty("ITEM_USER_ID")
	private int itemUserId;
	@JsonProperty("ITEM_CATEGORY_ID")
	private int itemCategoryId;
	
	public ItemAddForm(){}
	
	public ItemAddForm(String itemName, String itemDescription, String itemImage, boolean itemIsSold, int itemStatus,
			String itemPrice, Date itemPublishDate, int itemUserId, int itemCategoryId) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemImage = itemImage;
		this.itemIsSold = itemIsSold;
		this.itemStatus = itemStatus;
		this.itemPrice = itemPrice;
		this.itemPublishDate = itemPublishDate;
		this.itemUserId = itemUserId;
		this.itemCategoryId = itemCategoryId;
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

	public int getItemUserId() {
		return itemUserId;
	}

	public void setItemUserId(int itemUserId) {
		this.itemUserId = itemUserId;
	}

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	@Override
	public String toString() {
		return "ItemAddForm [itemName=" + itemName + ", itemDescription=" + itemDescription + ", itemImage=" + itemImage
				+ ", itemIsSold=" + itemIsSold + ", itemStatus=" + itemStatus + ", itemPrice=" + itemPrice
				+ ", itemPublishDate=" + itemPublishDate + ", itemUserId=" + itemUserId + ", itemCategoryId="
				+ itemCategoryId + "]";
	}

	public static class ItemUpdateForm extends ItemAddForm{
		@JsonProperty("ID")
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
	}
}
