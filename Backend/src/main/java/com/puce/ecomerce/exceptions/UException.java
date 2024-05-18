package com.puce.ecomerce.exceptions;

public class UException extends RuntimeException{
	
	private static final long serialVersionUID=1L;
	
	public UException() {
		super("user tiene una cuenta");
	}

}