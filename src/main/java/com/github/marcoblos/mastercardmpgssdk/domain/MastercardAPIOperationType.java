package com.github.marcoblos.mastercardmpgssdk.domain;

import org.springframework.http.HttpMethod;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardAPIOperationType {

	PAY("Payment (Purchase)", HttpMethod.PUT),
	RETRIEVE("Retrieve", HttpMethod.GET),
	REFUND("Refund", HttpMethod.PUT),
	NOOP("No operation", null);

	private String code;
	private String messageKey;
	private HttpMethod httpMethod;

	MastercardAPIOperationType(String messageKey, HttpMethod httpMethod) {
		code = this.name();
		this.messageKey = messageKey;
		this.httpMethod = httpMethod;
	}

}
