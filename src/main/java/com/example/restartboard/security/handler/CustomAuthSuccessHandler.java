package com.example.restartboard.security.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

	private final HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		 SavedRequest savedRequest = requestCache.getRequest(request, response);
		
        if (savedRequest != null) {
            requestCache.removeRequest(request, response);
            String redirectUrl = savedRequest.getRedirectUrl();
            response.sendRedirect(redirectUrl);
        } else {
            // SavedRequest가 없는 경우, 기본적으로 처리
            response.sendRedirect("/home");
        }
		
	}

}
