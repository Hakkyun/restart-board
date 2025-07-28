package com.example.restartboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restartboard.dto.BoardDTO;
import com.example.restartboard.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	};
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		boardMapper.insertBoard(boardDTO);
	}

	@Override
	public List<BoardDTO> selectAllPosts() {
		return boardMapper.selectAllPosts();
	}
	
}
