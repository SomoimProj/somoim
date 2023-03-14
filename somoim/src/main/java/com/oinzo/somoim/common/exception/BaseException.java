package com.oinzo.somoim.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException  {

	private final ErrorCode errorCode;

	// 의도적인 예외이므로 stack trace 제거 (불필요한 예외처리 비용 제거)
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

	public HttpStatus getHttpStatus() {
		return errorCode.getHttpStatus();
	}

}
