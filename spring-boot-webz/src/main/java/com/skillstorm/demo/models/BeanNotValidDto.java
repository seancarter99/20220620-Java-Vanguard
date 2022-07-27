package com.skillstorm.demo.models;

import java.util.Date;

// This is a design pattern known as a DTO
// We should look use DTOs when we want to shape our JSON that we send back
// This is important when limiting some of the data that goes over the wire
// 1. Prevents accidental leaking of sensitive data
// 2. Less bloat going over the wire
public class BeanNotValidDto {

	private Date timestamp;
	private String message;
	
	public BeanNotValidDto() {
		this.timestamp = new Date();
	}
	
	public BeanNotValidDto(String message) {
		this();
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
