package com.example.restartboard.dto;

import java.time.LocalDateTime;

import com.example.restartboard.entity.UserEntity;

public class UserDTO {

	private String userEmail;
	private String userPwd;
	private String userName;
	private String userNickname;
	
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
	
	// 일반 회원가입용 엔티티
	public UserEntity toUserEntity(String encryptedPwd) {
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserId(null);
		userEntity.setUserEmail(this.userEmail);
		userEntity.setUserPwd(encryptedPwd);
		userEntity.setUserName(this.userName);
		userEntity.setUserNickname(this.userNickname);
		userEntity.setUserRole("ROLE_USER");
		userEntity.setUserProvider("local");
		userEntity.setUserRegTime(LocalDateTime.now());
		
		return userEntity;
	}
	
	
}
