package com.example.demo.exceptions;

// NotFoundの具象クラス
public class ResourceNotFoundException extends Exception {
	
	// シリアル化プロセス
	private static final long serialVersionUID = -9079454849611061074L;
	
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
