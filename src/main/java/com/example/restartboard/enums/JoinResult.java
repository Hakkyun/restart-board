package com.example.restartboard.enums;

public enum JoinResult {
	SUCCESS("축하합니다! 회원으로 가입하셨습니다."),
	DUPLICATE_EMAIL("해당 이메일이 이미 존재합니다."),
	FAIL("죄송합니다. 회원가입에 문제가 생겨 실패했습니다.");
	
	private final String message;
	
    JoinResult(String message) {
        this.message = message;
    }
	
	public String getMessage() {
		return message;
	}
	
}
