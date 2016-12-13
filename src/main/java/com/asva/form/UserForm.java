package com.asva.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserForm {
	
	public static class LoginForm{
		
		@JsonProperty("EMAIL")
		private String email;
		
		@JsonProperty("PASSWORD")
		private String password;

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

		@Override
		public String toString() {
			return "LoginForm [email=" + email + ", password=" + password + "]";
		}
	}
	public static class ResetPasswordForm{
		
		@JsonProperty("USER_ID")
		private int userId;
		
		@JsonProperty("PASSWORD")
		private String password;
		
		@JsonProperty("CONFRIM_PASSWORD")
		private String comfirmPassword;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getComfirmPassword() {
			return comfirmPassword;
		}
		public void setComfirmPassword(String comfirmPassword) {
			this.comfirmPassword = comfirmPassword;
		}
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		@Override
		public String toString() {
			return "ResetPasswordForm [userId=" + userId + ", password=" + password + ", comfirmPassword="
					+ comfirmPassword + "]";
		}
		
		
	}
}
