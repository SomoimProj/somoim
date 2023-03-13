package com.oinzo.somoim.common.exception;

import com.oinzo.somoim.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class ErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BaseException.class)
	protected ResponseEntity<BaseResponse<?>> handleBaseException(BaseException e) {
		return ResponseEntity
			.status(e.getHttpStatus())
			.body(BaseResponse.error(e.getErrorCode()));
	}

	// 디버깅을 위해 주석 처리
	/*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	protected BaseResponse<?> handleRuntimeException(RuntimeException e) {
		log.error(e.getMessage());
		return BaseResponse.error(ErrorCode.INTERNAL_SERVER_ERROR);
	}*/
}
