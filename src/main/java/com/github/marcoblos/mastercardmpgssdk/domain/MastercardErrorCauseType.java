package com.github.marcoblos.mastercardmpgssdk.domain;

import lombok.Getter;

/**
 * 
 * @author marcoblos 2018-02-22
 *
 */
@Getter
public enum MastercardErrorCauseType {

	INVALID_REQUEST("The request was rejected because it did not conform to the API protocol"),
	REQUEST_REJECTED("The request was rejected due to security reasons such as firewall rules, expired certificate, etc"),
	SERVER_BUSY("The server did not have enough resources to process the request at the moment"),
	SERVER_FAILED("There was an internal system failure");

	private String code;
	private String messageKey;

	MastercardErrorCauseType(String messageKey) {
		code = this.name();
		this.messageKey = messageKey;
	}

}
