package com.example.restartboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; // ② @PreAuthorize 등 활성화
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // ③ 비밀번호 해시용
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.restartboard.security.handler.CustomAuthFailureHandler;

@Configuration
@EnableMethodSecurity 	// Security Filter를 등록
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity
//        	.csrf(csrf -> csrf.disable())                               	// (임시)인증 활성화 꺼둠, 개발 되면 삭제
        	.authorizeHttpRequests(auth -> auth                         	// URL별 접근 권한 정의
        		    .requestMatchers("/admin/**").hasRole("ADMIN")			// .hasRole("ADMIN") -> 특정 역할만 가능 
        		    .requestMatchers("/board/write").authenticated()		// authenticated() -> 로그인 하면 접근 가능
        		    .anyRequest().permitAll()                             	// permitAll() : 모두 접근 가능
        	)
        	.formLogin(form -> form
        		    .loginPage("/user/login")      						    // GET 로그인 페이지 URL
        		    .loginProcessingUrl("/user/loginProc") 					// POST 인증 요청 URL (필터가 가로챔)
        		    .usernameParameter("userEmail")    						// 아이디 파라미터 이름 : 이메일로 로그인 하니까 userEmail
        		    .passwordParameter("userPwd")   					    // 비번 파라미터 이름
        		    .defaultSuccessUrl("/home", false) 						// 성공 시 이동 경로
        		    .failureHandler(new CustomAuthFailureHandler())  		// 실패 메시지 커스텀 핸들러
        	)
        	.logout(logout -> logout
        		    .logoutUrl("/user/logout")           					// 로그아웃 요청 URL
        		    .logoutSuccessUrl("/home")          					// 성공 후 이동 경로
        		    .invalidateHttpSession(true)   							// 세션 무효화
        	)
        	.sessionManagement(session -> session.maximumSessions(1))		// 세션 제한해서 동시 로그인 방지
        	;

        return httpSecurity.build();
    }
}