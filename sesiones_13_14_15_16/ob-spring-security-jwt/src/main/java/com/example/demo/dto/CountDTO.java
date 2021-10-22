package com.example.demo.dto;

/**
 * Data transfer Object
 */
public class CountDTO {

	private Long count;
	private String message;
	
	public CountDTO() {
	}
	
	public CountDTO(Long count) {
		this.count = count;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
