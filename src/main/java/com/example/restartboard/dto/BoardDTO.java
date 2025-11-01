package com.example.restartboard.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class BoardDTO {
	
	private Long brdId;
	@NotBlank(message = "제목을 입력하셔야 합니다.")
	private String brdTitle;
	private Long writerId;
	private String writerNickname;
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
	public Long getWriterId() {
		return writerId;
	}
	public void setBrdWriteId(Long writerId) {
		this.writerId = writerId;
	}
	public String getWriterNickname() {
		return writerNickname;
	}
	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
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
