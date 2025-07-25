package com.example.restartboard.dto;

import java.time.LocalDateTime;

public class BoardDTO {
	private String title;
	private String writer;
	private String content;
	private LocalDateTime writeTime;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(LocalDateTime localDateTime) {
		this.writeTime = localDateTime;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [title=" + title + ", writer=" + writer + ", content=" + content + ", writeTime=" + writeTime
				+ "]";
	}
	
	
}
