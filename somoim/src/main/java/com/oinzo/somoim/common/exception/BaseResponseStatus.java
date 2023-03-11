package com.oinzo.somoim.common.exception;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {

    SUCCESS(1000, "요청에 성공하였습니다."),

    NO_FAVORITE(2001, "관심사를 선택하세요");


    private final int code;
    private final String message;

    private BaseResponseStatus( int code, String message) {
        this.code = code;
        this.message = message;
    }
}
