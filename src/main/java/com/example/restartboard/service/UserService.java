package com.example.restartboard.service;

import com.example.restartboard.dto.UserDTO;
import com.example.restartboard.enums.JoinResult;
import com.example.restartboard.enums.LoginResult;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	// 회원가입 서비스
	JoinResult JoinUser(UserDTO userDTO);
	
	// 로그인을 위한 회원정보 조회
	LoginResult login(String userEmail, String userPwd, HttpSession session);
}
