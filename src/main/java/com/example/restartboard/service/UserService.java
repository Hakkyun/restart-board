package com.example.restartboard.service;

import com.example.restartboard.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	// 회원가입 서비스
	void JoinUser(UserEntity user);
	
	// 로그인을 위한 회원정보 조회
	LoginResult login(String userEmail, String userPwd, HttpSession session);
}
