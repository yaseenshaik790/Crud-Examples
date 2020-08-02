package com.hcl.crud.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResponse {

	@JsonProperty("message")
	private String message;
	@JsonProperty("STATUS_CODE")
	private Integer STATUS_CODE = 709;

	@JsonProperty("STATUS_CODE")
	public Integer getStatusCode() {
		return STATUS_CODE;
	}

	public CustomerResponse(String message, Integer sTATUS_CODE) {
		super();
		this.message = message;
		STATUS_CODE = sTATUS_CODE;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

}
