package com.example.restartboard.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class BoardDTO {
	
	private Long brdId;
	@NotBlank(message = "제목을 입력하셔야 합니다.")
	private String brdTitle;
	@NotBlank(message = "작성자를 입력하셔야 합니다.")
	private String brdWriter;
	@NotBlank(message = "내용을 입력하셔야 합니다.")
	private String brdContent;
	private LocalDateTime brdRegTime;
	
	public Long getBrdId() {
		return brdId;
	}
	public void setBrdId(Long brdId) {
		this.brdId = brdId;
	}
	public String getBrdTitle() {
		return brdTitle;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	public String getBrdWriter() {
		return brdWriter;
	}
	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}
	public String getBrdContent() {
		return brdContent;
	}
	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}
	public LocalDateTime getBrdRegTime() {
		return brdRegTime;
	}
	public void setBrdRegTime(LocalDateTime brdRegTime) {
		this.brdRegTime = brdRegTime;
	}
	
		
}
