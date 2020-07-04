package com.simpragma.management.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 3726580414853494059L;

	private int userId;

	private String userName;

	@JsonProperty("id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@JsonProperty("name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
