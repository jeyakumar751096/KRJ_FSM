package com.fms.springsecurity.login.exception;

public class ErrorResponse {
	 private int code;
	    private String developerMessage;

	    public ErrorResponse(int code, String developerMessage) {
	        this.code = code;
	        this.developerMessage = developerMessage;
	    }

	    public int getCode() {
	        return code;
	    }

	    public String getDeveloperMessage() {
	        return developerMessage;
	    }
}
