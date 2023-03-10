package com.Oinzo.somoim.common.exception;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    SUCCESS(1000, "요청에 성공하였습니다."),

    Fail(2000, "실패하였습니다.");

    private final int code;
    private final String message;

    private BaseResponseStatus( int code, String message) {
        this.code = code;
        this.message = message;
    }
}
