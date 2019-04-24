package com.application.exception;

/**
 * 自定义token过期异常类
 * @class TokenExpirationException
 * @author Jason
 * @description
 * @date Apr 24, 2019 2:09:58 PM
 */
public class TokenExpirationException extends Exception {

	private static final long serialVersionUID = 1L;

	public TokenExpirationException() {
		super();
	}

	public TokenExpirationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TokenExpirationException(String message, Throwable cause) {
		super(message, cause);
	}

	public TokenExpirationException(String message) {
		super(message);
	}

	public TokenExpirationException(Throwable cause) {
		super(cause);
	}

	
	
}
