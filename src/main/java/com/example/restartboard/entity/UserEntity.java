package com.example.restartboard.entity;

import java.time.LocalDateTime;

public class UserEntity {

	private Long   userId;
	private String userEmail;
	private String userPwd;
	private String userName;
	private String userNickname;
	private String userRole;
	private String userProvider;
	private LocalDateTime userRegTime;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserProvider() {
		return userProvider;
	}
	public void setUserProvider(String userProvider) {
		this.userProvider = userProvider;
	}
	public LocalDateTime getUserRegTime() {
		return userRegTime;
	}
	public void setUserRegTime(LocalDateTime userRegTime) {
		this.userRegTime = userRegTime;
	}
	
	
	
}
