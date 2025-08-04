package com.example.restartboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restartboard.service.LoginResult;
import com.example.restartboard.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 로그인 화면 요청
	@GetMapping("/user/login")
	public String loginView() {
		return "user/login";			// template/user/login.html 
	}
	
	// 로그인 처리
	@PostMapping("/user/login")
	public String login(@RequestParam String userEmail, @RequestParam String userPwd, HttpSession session, Model model) {
		
		LoginResult loginResult = userService.login(userEmail, userPwd, session);
		
		switch(loginResult) {
			case NO_USER -> model.addAttribute("loginError", "회원이 존재하지 않습니다.");
			case WRONG_PASSWORD -> model.addAttribute("loginError", "비밀번호가 틀렸습니다.");
			case SUCCESS -> {
				return "redirect:/";
			}
		}
		
	    return "/user/login"; 
	}	
	
	// 로그아웃 처리
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();	// 세션 전체 삭제
		return "redirect:/";
	}
	
	
}
