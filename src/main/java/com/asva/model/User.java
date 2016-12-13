package com.asva.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends BaseModel{
	@JsonProperty("USER_FIRST_NAME")
	private String userFirstName;
	@JsonProperty("USER_LAST_NAME")
	private String userLastName;
	@JsonProperty("USER_GENDER")
	private String userGender;
	@JsonProperty("USER_EMAIL")
	private String userEmail;
	@JsonIgnore
	@JsonProperty("USER_PASSWORD")
	private String userPassword;
	@JsonProperty("USER_PHOTO")
	private String userPhoto;
	
	/*
	 * User Status Note
	 * 0 = inactive
	 * 1 = active
	 * */
	@JsonProperty("USER_STATUS")
	private int userStatus;
	@JsonProperty("USER_TELEPHONE")
	private String userTelephone;
	@JsonProperty("USER_ROLE")
	private UserRole userRole;
	
	public User(){}
	
	public User(String userFirstName, String userLastName, String userGender, String userEmail, String userPassword,
			String userPhoto, int userStatus, String userTelephone, UserRole userRole) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhoto = userPhoto;
		this.userStatus = userStatus;
		this.userTelephone = userTelephone;
		this.userRole = userRole;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userGender=" + userGender
				+ ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userPhoto=" + userPhoto
				+ ", userStatus=" + userStatus + ", userTelephone=" + userTelephone + ", userRole=" + userRole + "]";
	}
}
