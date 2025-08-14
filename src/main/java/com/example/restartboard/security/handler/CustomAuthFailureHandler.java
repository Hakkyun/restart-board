package com.example.restartboard.security.handler;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class CustomAuthFailureHandler implements AuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
        String msg = (exception instanceof UsernameNotFoundException) ? "가입된 회원이 없습니다"
                : (exception instanceof BadCredentialsException)   ? "비밀번호가 틀렸습니다"
                : "로그인에 실패했습니다";	

        response.sendRedirect("/user/login?error=" + URLEncoder.encode(msg, StandardCharsets.UTF_8));
		
	}
	
}
