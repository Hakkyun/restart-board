package com.example.restartboard.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restartboard.entity.UserEntity;
import com.example.restartboard.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	};
	
	@Override
	public void JoinUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LoginResult login(String userEmail, String userPwd, HttpSession session) {
	
		UserEntity user = userMapper.findByEmail(userEmail);

		if(user == null) {
			return LoginResult.NO_USER;
		}
		
		if(!passwordEncoder.matches(userPwd, user.getUserPwd())) {
			return LoginResult.WRONG_PASSWORD;
		}
		
		session.setAttribute("loginUser", user);
		return LoginResult.SUCCESS;
	}

	
	
}
