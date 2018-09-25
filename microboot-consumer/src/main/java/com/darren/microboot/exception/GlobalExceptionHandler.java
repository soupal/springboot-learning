package com.darren.microboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(Exception.class)
	public Object defaultErrorHandler(HttpServletRequest request, Exception e) {

		class ErrorInfo {

			@SuppressWarnings("unused")
			private Integer code;
			@SuppressWarnings("unused")
			private String message;
			@SuppressWarnings("unused")
			private String url;
			public void setCode(Integer code) {
				this.code = code;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			public void setUrl(String url) {
				this.url = url;
			}

		}

		ErrorInfo info = new ErrorInfo();

		info.setCode(100);
		info.setMessage(e.getMessage());
		info.setUrl(request.getRequestURL().toString());
		return info;

	}

}
