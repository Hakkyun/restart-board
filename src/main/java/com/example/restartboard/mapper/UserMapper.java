package com.example.restartboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.restartboard.entity.UserEntity;

@Mapper
public interface UserMapper {

	UserEntity findByEmail(@Param("userEmail") String userEmail);
	
}
