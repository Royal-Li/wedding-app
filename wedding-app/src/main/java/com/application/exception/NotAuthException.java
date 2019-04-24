package com.application.exception;

/**
 * 自定义认证信息不正确异常类 
 * @class NotAuthException
 * @author Jason
 * @description
 * @date Apr 24, 2019 2:09:24 PM
 */
public class NotAuthException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotAuthException() {
		super();
	}

	public NotAuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotAuthException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotAuthException(String message) {
		super(message);
	}

	public NotAuthException(Throwable cause) {
		super(cause);
	}

}
