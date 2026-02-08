package com.lyj.assetService.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USER_NOT_FOUND("없는 이메일입니다.", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD("비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED);

    private final String message;
    private final HttpStatus status;

    ErrorCode(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() { return message; }
    public HttpStatus getStatus() { return status; }
}