package com.example.restartboard.security;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.restartboard.entity.UserEntity;

// 인증·인가를 위해 Security가 들고 다니는 최소 정보
// 로그인 한 사용자를 Security가 이해할 수 있는 형태
public class CustomUserDetails implements UserDetails {

	// 도메인 로직과 화면/권한 체크에서 가장 자주 쓰는 최소값만 보관
	private final Long id;                    			// 글 작성자 비교, 로깅/감사에 필요 (DB PK)
	private final String email;               			// 로그인 식별자 (Security username)
	private final String password;            			// 암호화된 비번
	private final String nickname;           			// 헤더/뷰 표시
	private final List<GrantedAuthority> authorities;	// 권한 분기(USER/ADMIN 등)
	
	// “도메인 → 보안 스냅샷” 변환자 역할
	public CustomUserDetails(UserEntity user) {
        this.id = user.getUserId();            			// 도메인의 PK를 스냅샷에 복제(가벼운 값)
        this.email = user.getUserEmail();       		// 이메일을 username으로 사용
        this.password = user.getUserPwd(); 				// 이미 BCrypt로 저장돼 있어야 함 (회원가입 시 인코딩)
        this.nickname = user.getUserNickname(); 		// 화면에서 바로 쓰려는 값
        // Security는 "ROLE_" 접두사를 기대하니 여기서 표준화
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserRole()));
	}
	
    // 컨트롤러/뷰에서 꺼내 쓸 “추가 필드” 접근자
    public Long getId() {
    	return id; 
    }
    public String getNickname() { 
    	return nickname; 
    }
    
    // ▼▼▼ 아래 7개는 UserDetails “규약” 구현 — Security가 내부에서 호출 ▼▼▼
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;	// 권한 체크 sec:authorize/hasRole 에서 사용
    }

    @Override
    public String getPassword() {
        return password;	// 로그인 시 암호 비교는 Security가 여기서 꺼낸 해시로 처리
    }

    @Override
    public String getUsername() {
        return email; // username으로 이메일 사용
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 로직 없으면 true
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 잠금 로직 없으면 true
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비번 만료 로직 없으면 true
    }

    @Override
    public boolean isEnabled() {
        return true; // 활성 상태
    } 
    
    
}
