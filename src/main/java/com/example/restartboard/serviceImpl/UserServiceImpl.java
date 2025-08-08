package com.example.restartboard.serviceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.restartboard.dto.UserDTO;
import com.example.restartboard.entity.UserEntity;
import com.example.restartboard.enums.JoinResult;
import com.example.restartboard.enums.LoginResult;
import com.example.restartboard.mapper.UserMapper;
import com.example.restartboard.service.UserService;

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
	public JoinResult JoinUser(UserDTO userDTO) {
		
		try {
			// 비밀번호 암호화
			String encryptedPwd = passwordEncoder.encode(userDTO.getUserPwd());
			
			// DTO -> Entity 변환
			UserEntity userEntity = userDTO.toUserEntity(encryptedPwd);
			
			userMapper.joinUser(userEntity);
			
			return JoinResult.SUCCESS;
		} catch (Exception e) {
			return JoinResult.FAIL;			
		}
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
