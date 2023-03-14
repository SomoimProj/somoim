package com.oinzo.somoim.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.oinzo.somoim.common.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonPropertyOrder({"code", "message", "result"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    public static final BaseResponse<?> SUCCESS_NO_DATA = new BaseResponse<>(); // 전송할 데이터가 없는 성공 응답

    private int code;
    private String message;
    private T result;

    private BaseResponse(T result) {
        this.result = result;
    }

    private BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(data);
    }

    public static BaseResponse<?> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode.getCode(), errorCode.getMessage());
    }
}
