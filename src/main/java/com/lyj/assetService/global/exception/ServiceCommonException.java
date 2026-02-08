package com.lyj.assetService.global.exception;

public class ServiceCommonException extends RuntimeException{
    private final ErrorCode  errorCode;

    public ServiceCommonException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
