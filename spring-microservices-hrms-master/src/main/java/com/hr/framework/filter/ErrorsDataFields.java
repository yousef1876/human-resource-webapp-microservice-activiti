package com.hr.framework.filter;

import java.io.Serializable;

public class ErrorsDataFields implements Serializable{

	private String error;
	
	private String description;

	public String getError() {
		return error;
	}

	public ErrorsDataFields(){}
	
	public void setError(String error) {
		this.error = error;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
