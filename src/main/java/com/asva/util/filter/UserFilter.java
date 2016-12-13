package com.asva.util.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author PHEARUN
 * Created Date: 14/07/2016
 * Email: rathphearun123@gmail.com
 * Reference: Dara Penhchet
 * */
public class UserFilter extends BaseModelFilter{

	@JsonProperty("BY_FIRSTNAME")
	private String firstName = "";
	
	@JsonProperty("BY_LASTNAME")
	private String lastName = "";
		
	@JsonProperty("BY_ROLE_NAME")
	private String roleName = "";
	
	public UserFilter(){
		System.out.println("userfilter");
	}
	
	public UserFilter(String firstName, String lastName, String roleName, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleName = roleName;
		this.status = status;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserFilter [firstName=" + firstName + ", lastName=" + lastName + ", roleName=" + roleName + ", status="
				+ status + "]";
	}
	
	
	
}
