package com.example.restartboard.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.restartboard.dto.BoardDTO;
import com.example.restartboard.service.BoardService;

import jakarta.validation.Valid;

@Controller
public class BoardController {

	// 서비스 필드를 생성, final은 다른곳에서 수정되는 것 방지
	private final BoardService boardService;
	// 생성자를 통해서만 서비스 필드 수정, 생성자 하나일 경우 @Autowired 생략 가능
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	};
	// 예전 버전 1
	// BoardController boardController = new BoardController(); 로 생성해서 사용
	// 예전 버전 2
	// @Autowired
	// BoardService boardService;
	
	@GetMapping("/board")
	public String board(Model model) {
		List<BoardDTO> postList = boardService.selectAllPosts();
		model.addAttribute("posts", postList);
		return "board/board";			// template/board/board.html 
	}

	@GetMapping("/board/write")
	public String boardWrite(Model model) {
		model.addAttribute("boardDTO", new BoardDTO());
		return "board/board-write";		// template/board/boardWrite.html 
	}
	
	@PostMapping("/board/write")
	public String write(@Valid @ModelAttribute BoardDTO boardDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("boardDTO", boardDTO);
			return "board/board-write";
		}
		
		boardDTO.setBrdRegTime(LocalDateTime.now());
		boardService.insertBoard(boardDTO);
	    return "redirect:/board";
	}
	
}
