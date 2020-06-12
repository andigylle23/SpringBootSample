package com.example.demo.model;

public class ExceptionResponse {
	
	private String errorMessage;
	private String requestedURI;
	private String requestMethod;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getRequestURI() {
		return requestedURI;
	}
	
	public String getRequestMethod() {
		return requestMethod;
	}
	
	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setRequetedURI(final String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public void setRequestMethod(final String requestMethod) {
		this.requestMethod = requestMethod;
	}
}
