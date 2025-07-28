package com.example.restartboard.service;

import java.util.List;

import com.example.restartboard.dto.BoardDTO;

public interface BoardService {
	
	// 글쓰기로 쓴 글 DB에 등록하는 기능
	void insertBoard(BoardDTO boardDTO);
	
	// DB에 저장되어 있는 글들 가져오는 기능
	List<BoardDTO> selectAllPosts();
	
}
