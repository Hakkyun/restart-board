package com.example.restartboard.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restartboard.dto.BoardDTO;
import com.example.restartboard.mapper.BoardMapper;
import com.example.restartboard.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	};
	
	@Override
	public void insertBoard(BoardDTO boardDTO) {
		// 받아온 유저 정보로 유저 닉네임 꺼내서 boardDTO에 넣기
		
		boardMapper.insertBoard(boardDTO);
	}

	@Override
	public List<BoardDTO> selectAllPosts() {
		return boardMapper.selectAllPosts();
	}
	
}
