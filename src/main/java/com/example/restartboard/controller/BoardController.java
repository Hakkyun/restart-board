package com.example.restartboard.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restartboard.dto.BoardDTO;
import com.example.restartboard.security.CustomUserDetails;
import com.example.restartboard.service.BoardService;

import jakarta.validation.Valid;

@RequestMapping("/board")
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
	
	// 게시판 화면 요청
	@GetMapping({"", "/"})
	public String board(Model model) {
		List<BoardDTO> postList = boardService.selectAllPosts();
		model.addAttribute("posts", postList);
		return "board/board";			// template/board/board.html 
	}

	// 글 작성 화면 요청
	@GetMapping("/write")
	public String boardWrite(Model model) {
		model.addAttribute("boardDTO", new BoardDTO());
		return "board/board-write";		// template/board/boardWrite.html 
	}
	
	// 글 작성 처리
	@PostMapping("/write")
	@PreAuthorize("isAuthenticated()")	// 메소드 단계에서도 로그인 여부 확인(이중 방지)
	public String write(@Valid @ModelAttribute BoardDTO boardDTO, BindingResult bindingResult, @AuthenticationPrincipal CustomUserDetails me, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("boardDTO", boardDTO);
			return "board/board-write";
		}
		
		boardDTO.setBrdRegTime(LocalDateTime.now());
		boardDTO.setBrdWriteId(me.getId());
		boardService.insertBoard(boardDTO);
	    return "redirect:/board";
	}
	
	// 글 상세페이지(만들기 예정)
	
}
