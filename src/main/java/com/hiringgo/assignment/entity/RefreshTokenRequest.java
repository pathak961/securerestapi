package com.hiringgo.assignment.entity;

public class RefreshTokenRequest {

	private String email;
	private String refreshToken;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public RefreshTokenRequest(String email, String refreshToken) {
		super();
		this.email = email;
		this.refreshToken = refreshToken;
	}

}
