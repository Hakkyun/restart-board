package com.example.restartboard.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.restartboard.dto.BoardDTO;
import com.example.restartboard.service.BoardService;

@Controller
public class BoardController {

	@GetMapping("/board")
	public String board() {
		return "board/board";			// template/board/board.html 
	}

	@GetMapping("/board/write")
	public String boardWrite() {
		return "board/board-write";		// template/board/boardWrite.html 
	}
	
	@PostMapping("/board/write")
	public String write(BoardDTO boardDTO) {
		boardDTO.setWriteTime(LocalDateTime.now());
		System.out.println(boardDTO.toString());
		
		BoardService boardService = new BoardService();
	    boardService.insertBoard(boardDTO);
	    return "redirect:/board";
	}
	
}
