package com.gmt.myschool.responses;

public class MessageResponse extends SuperResponse{

	private String message;
	
	public MessageResponse() {
		super();
		this.message = "";
	}
	
	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
