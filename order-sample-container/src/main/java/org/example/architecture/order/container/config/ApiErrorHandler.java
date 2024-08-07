package org.example.architecture.order.container.config;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.example.architecture.order.core.domain.product.exceptions.OrderCreationException;
import org.example.architecture.order.core.domain.product.exceptions.OrderCurrencyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class ApiErrorHandler {

	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";
	public static final int HEX_MAX_VALUE = 0xFFFFFF;
	private final Random secureRandom = new SecureRandom();

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NoResourceFoundException.class})
	public ErrorResponse handleNotFoundResource(@NonNull NoResourceFoundException ex) {

		return buildError(HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({OrderCreationException.class, OrderCurrencyException.class})
	public ErrorResponse handleOrderCreationExceptions(@NonNull RuntimeException ex) {

		return buildError(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage());
	}


	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleValidationExceptions() {
		return buildError("constraint_violation", "One or more fields doesn't respect the request expectations");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {

		var hexadecimal = Integer.toHexString(secureRandom.nextInt(HEX_MAX_VALUE + 1));
		ErrorResponse errorResponse = buildError(INTERNAL_SERVER_ERROR.getReasonPhrase(), "A technical error occurred during the execution of the action. Technical code : " + hexadecimal);
		log.error("A technical error occurred during the execution of the action. Technical code : " + hexadecimal, ex);
		var headersResponse = new HttpHeaders();
		headersResponse.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
		return new ResponseEntity<>(errorResponse, headersResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ErrorResponse buildError(String message, Serializable details) {
		return new ErrorResponse()
				.setError(message)
				.setErrorDescription(details);
	}

	@Getter
	@Setter
	@Accessors(chain = true)
	public static class ErrorResponse {

		private String error;
		private Serializable errorDescription;
		private Object errorDetails;
	}
}
