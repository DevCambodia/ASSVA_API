package com.asva.model.user;

import com.asva.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created Date: 14/07/2016
 * Author: Rath Phearun
 * Email: rathphearun123@gmail.com
 * 
 * */
public class User extends BaseModel{
	
	@JsonProperty("FIRST_NAME")
	private String firstName;
	
	@JsonProperty("LAST_NAME")
	private String lastName;
	
	@JsonProperty("GENDER")
	private String gender;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty("PHOTO")
	private String photo;
	
	@JsonProperty("STATUS")
	private int status = 1;
	
	@JsonProperty("TELEPHONE")
	private String telephone;
	
	@JsonProperty("ROLE")
	private Role role;

	public User(){
		
	}
	
	public User(int id, String firstName, String lastName, String gender, String email, String password, String photo,
			int status, String telephone, Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.photo = photo;
		this.status = status;
		this.telephone = telephone;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int isStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email
				+ ", password=" + password + ", photo=" + photo + ", status=" + status + ", telephone=" + telephone
				+ ", role=" + role + "]";
	}
	
	
}
