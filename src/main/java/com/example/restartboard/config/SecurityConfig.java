package com.example.restartboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	// 암호화용 PasswordEncoder Bean 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    // 모든 요청 허용 + 로그인 필터 비활성화
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // CSRF 비활성화 (폼 제출 가능)
            .authorizeHttpRequests((auth) -> auth
                .anyRequest().permitAll() // 모든 요청 허용
            )
            .formLogin().disable(); // 기본 로그인 필터 제거

        return http.build();
    }
	
}
