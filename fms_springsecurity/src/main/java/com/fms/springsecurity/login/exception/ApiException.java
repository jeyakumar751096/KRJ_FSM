package com.fms.springsecurity.login.exception;

public class ApiException extends RuntimeException{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String message;
	    private final int code;

	    public ApiException(final String message, final int code) {
	        super(message);
	        this.message = message;
	        this.code = code;
	    }

	    public ApiException(final String message, final int code, Throwable throwable) {
	        super(message, throwable);
	        this.message = message;
	        this.code = code;
	    }

	    @Override
	    public String getMessage() {
	        return message;
	    }

	    public int getCode() {
	        return code;
	    }

}
