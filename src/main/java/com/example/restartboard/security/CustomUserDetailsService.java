package com.example.restartboard.security;

import org.springframework.security.core.userdetails.*; // ← UserDetails, Service 인터페이스
import org.springframework.stereotype.Service;

import com.example.restartboard.entity.UserEntity;
import com.example.restartboard.mapper.UserMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
  private final UserMapper userMapper;
  
  public CustomUserDetailsService(UserMapper userMapper) {
	  this.userMapper = userMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String userEmail) {
	  
      // DB 조회: 이메일로 사용자 한 명 찾기 (없으면 null/Optional.empty)
      UserEntity user = userMapper.findByEmail(userEmail);
      
      if (user == null) {		// "회원 없음" → 인증 실패로 분기
          throw new UsernameNotFoundException("해당 이메일로 가입된 회원이 없습니다.");
      }
	  
      // 성공: 도메인 User → 보안 스냅샷(CustomUserDetails) 변환
      //    (왜 변환?) 세션에는 가벼운 스냅샷만 올려서 화면/권한 체크에 사용
      // 커스텀 UserDetails 구현체 사용
      return new CustomUserDetails(user);
  }
  
  
}