package com.example.restartboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.restartboard.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	
	void insertBoard(BoardDTO boardDTO);

	List<BoardDTO> selectAllPosts();
	
}
