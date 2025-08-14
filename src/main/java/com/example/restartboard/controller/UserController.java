package com.example.restartboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restartboard.dto.UserDTO;
import com.example.restartboard.enums.JoinResult;
import com.example.restartboard.enums.LoginResult;
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
	
//	// 로그인 처리
//	@PostMapping("/user/loginProc")
//	public String login(@RequestParam String userEmail, @RequestParam String userPwd, HttpSession session, Model model) {
//		
//		LoginResult loginResult = userService.login(userEmail, userPwd, session);
//		
//		switch(loginResult) {
//			case NO_USER -> model.addAttribute("loginError", "회원이 존재하지 않습니다.");
//			case WRONG_PASSWORD -> model.addAttribute("loginError", "비밀번호가 틀렸습니다.");
//			case SUCCESS -> {
//				return "redirect:/home";
//			}
//		}
//		
//	    return "user/login"; 
//	}	
	
	// 로그아웃 처리
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();	// 세션 전체 삭제
		return "redirect:/home";
	}
	
	// 회원가입 화면 요청
	@GetMapping("/user/join")
	public String joinView(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "user/join";			// template/user/join.html
	}
	
	// 회원가입 처리
	@PostMapping("/user/join")
	public String join(@ModelAttribute UserDTO userDTO, Model model) {
		JoinResult joinResult = userService.JoinUser(userDTO);
		
		model.addAttribute("joinResult", joinResult.name());
		model.addAttribute("joinMessage", joinResult.getMessage());
		
		return joinResult == joinResult.SUCCESS ? "/home" : "user/join";
	}

	
	
}
