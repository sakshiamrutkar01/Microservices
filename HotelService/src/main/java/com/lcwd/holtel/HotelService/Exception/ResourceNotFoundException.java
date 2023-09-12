package com.lcwd.holtel.HotelService.Exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super("Resource Not found on server ");
		// TODO Auto-generated constructor stub
	}
	
	public ResourceNotFoundException() {
		super("Resource Not found on server ");
		// TODO Auto-generated constructor stub
	}

	
}
