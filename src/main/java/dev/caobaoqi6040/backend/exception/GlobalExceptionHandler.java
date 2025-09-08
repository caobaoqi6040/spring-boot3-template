package dev.caobaoqi6040.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

/**
 * GlobalExceptionHandler
 *
 * @author caobaoqi6040
 * @since 2025/9/8 16:59
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ProblemDetail handlerException(Exception ex) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		problemDetail.setTitle("spring-boot3-template");
		problemDetail.setDetail("服务器内部错误 请联系 ikun");
		problemDetail.setType(URI.create("/errors/internal-server-error"));

		log.warn("GlobalExceptionHandler[Exception]", ex);

		return problemDetail;
	}

}
