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

	PAY("Payment (Purchase)", HttpMethod.PUT, MastercardRequestType.TRANSACTION),
	RETRIEVE("Retrieve", HttpMethod.GET, MastercardRequestType.TRANSACTION),
	REFUND("Refund", HttpMethod.PUT, MastercardRequestType.TRANSACTION),
	NOOP("No operation", null, MastercardRequestType.TRANSACTION),
	CREATE_CHECKOUT_SESSION("Create checkout session", HttpMethod.POST, MastercardRequestType.SESSION);

	private String code;
	private String messageKey;
	private HttpMethod httpMethod;
	private MastercardRequestType requestType;

	MastercardAPIOperationType(String messageKey, HttpMethod httpMethod, MastercardRequestType requestType) {
		code = this.name();
		this.messageKey = messageKey;
		this.httpMethod = httpMethod;
		this.requestType = requestType;
	}

}
